import json
import re
from xml.etree import ElementTree

import requests


def get_destroystokyo_com_maven():
    response = requests.get(
        "https://papermc.io/repo/repository/maven-public/com/destroystokyo/paper/paper-api/maven-metadata.xml")
    if response.status_code != 200:
        return None
    xml = ElementTree.fromstring(response.text)
    xml_versions = xml.find("versioning").find("versions").iter("version")

    ret_versions = {}

    for version in xml_versions:
        pattern = re.compile(r"^[1-9]+\.[0-9]+")

        major_version = pattern.match(version.text).group()
        ret_versions[major_version] = version.text

    return ret_versions


def get_paper_io_maven():
    response = requests.get(
        "https://papermc.io/repo/repository/maven-public/io/papermc/paper/paper-api/maven-metadata.xml")
    if response.status_code != 200:
        return None
    xml = ElementTree.fromstring(response.text)
    xml_versions = xml.find("versioning").find("versions").iter("version")

    ret_versions = {}

    for version in xml_versions:
        pattern = re.compile(r"^[1-9]+\.[0-9]+")

        major_version = pattern.match(version.text).group()
        ret_versions[major_version] = version.text

    return ret_versions


# https://paper.readthedocs.io/en/latest/server/getting-started.html#requirements
java_versions = {
    "1.16": "16",
    "1.17": "16",
    "1.18": "17",
    "1.19": "17",
    "1.20": "17"
}

versions = []
for (javadoc_version, ver) in get_destroystokyo_com_maven().items():
    if javadoc_version not in java_versions:
        continue
    versions.append(json.dumps({
        "groupId": "com.destroystokyo.paper",
        "javadoc_version": javadoc_version,
        "version": ver,
        "java_version": java_versions[javadoc_version]
    }))

for (javadoc_version, ver) in get_paper_io_maven().items():
    if javadoc_version not in java_versions:
        continue
    versions.append(json.dumps({
        "groupId": "io.papermc.paper",
        "javadoc_version": javadoc_version,
        "version": ver,
        "java_version": java_versions[javadoc_version]
    }))

print(json.dumps(versions))
