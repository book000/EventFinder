import json
import re
from xml.etree import ElementTree

import requests
import semver
from bs4 import BeautifulSoup


def get_destroystokyo_com_maven():
    response = requests.get(
        "https://papermc.io/repo/repository/maven-public/com/destroystokyo/paper/paper-api/maven-metadata.xml")
    if response.status_code != 200:
        return None
    xml = ElementTree.fromstring(response.text)
    xml_versions = xml.find("versioning").find("versions").iter("version")

    versions = []
    for version in xml_versions:
        versions.append(version.text)

    return versions


def get_paper_io_maven():
    response = requests.get(
        "https://papermc.io/repo/repository/maven-public/io/papermc/paper/paper-api/maven-metadata.xml")
    if response.status_code != 200:
        return None
    xml = ElementTree.fromstring(response.text)
    xml_versions = xml.find("versioning").find("versions").iter("version")

    versions = []
    for version in xml_versions:
        versions.append(version.text)
    return versions

def get_version(version):
    return version.split("-")[0]


def get_major_version(version):
    return re.match(r"\d+\.\d+", version).group(0)

def get_semver_ajusted_version(version):
    # semverに適するようにバージョンを調整
    adjusted_version = version
    # 1.11-R0.1-SNAPSHOT -> 1.11
    if adjusted_version.count("-") > 0:
        adjusted_version = adjusted_version.split("-")[0]
    # 1.11 -> 1.11.0
    if adjusted_version.count(".") == 1:
        adjusted_version = adjusted_version + ".0"
    return adjusted_version


def get_java_version(version):
    # https://paper.readthedocs.io/en/latest/server/getting-started.html#requirements

    # semverに適するようにバージョンを調整
    adjusted_version = get_semver_ajusted_version(version)

    # semverに基づき、Javaバージョンを返す
    if semver.match(adjusted_version, "<=1.11.0"):
        return "8"
    elif semver.match(adjusted_version, "<=1.16.4"):
        return "11"
    elif semver.match(adjusted_version, "<=1.16.5"):
        return "16"
    else:
        return "21"


def is_supported_version(version):
    # rc, pre, snapshotなどのバージョンはサポートしない
    if "rc" in version or "pre" in version or "snapshot" in version:
        return False

    ajusted_version = get_semver_ajusted_version(version)
    # PaperMC 1.16.5以降をサポートする
    return semver.match(ajusted_version, ">=1.16.5")


def get_javadoc_version(version):
    # https://jd.papermc.io/paper/<version>/ にアクセスし、404が返ってきたらメジャーバージョンで存在確認を行う。
    # メジャーバージョンでの存在確認の場合、h1タグのテキストを確認し、"paper-api <version>-R0.1-SNAPSHOT API" の <version> が一致するか確認する。
    ajusted_version = get_version(version)
    response = requests.get(f"https://jd.papermc.io/paper/{ajusted_version}/")
    if response.status_code == 200:
        return ajusted_version

    major_version = get_major_version(ajusted_version)
    if major_version == ajusted_version:
        return None
    major_response = requests.get(f"https://jd.papermc.io/paper/{major_version}/")
    if major_response.status_code != 200:
        return None

    soup = BeautifulSoup(major_response.text, "html.parser")
    h1 = soup.find("h1")
    if h1 is None:
        return None
    h1_text = h1.text
    if version in h1_text:
        return major_version

    return None


versions = []
for version in get_destroystokyo_com_maven():
    if not is_supported_version(version):
        continue

    javadoc_version = get_javadoc_version(version)
    java_version = get_java_version(version)

    versions.append(json.dumps({
        "groupId": "com.destroystokyo.paper",
        "javadoc_version": javadoc_version,
        "version": version,
        "java_version": java_version
    }))

for version in get_paper_io_maven():
    if not is_supported_version(version):
        continue

    javadoc_version = get_javadoc_version(version)
    java_version = get_java_version(version)

    versions.append(json.dumps({
        "groupId": "io.papermc.paper",
        "javadoc_version": javadoc_version,
        "version": version,
        "java_version": java_version
    }))

# javadocが存在しないバージョンを除外
versions = list(filter(lambda x: json.loads(x)["javadoc_version"] is not None, versions))

print(json.dumps(versions))
