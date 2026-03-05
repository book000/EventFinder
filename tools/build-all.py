#!/usr/bin/env python3
"""全バージョンのビルドを順に実行するスクリプト"""

import json
import os
import re
import shutil
import subprocess
import sys
from xml.etree import ElementTree

import requests
import semver
from bs4 import BeautifulSoup

LISTENERS_DIR = "./src/main/java/com/tomacheese/eventfinder/listeners"
MVN = os.path.expanduser("~/tools/apache-maven-3.9.9/bin/mvn")
JAVA_HOME = os.path.expanduser("~/tools/jdk-21.0.6+7")


def get_maven_versions(url):
    response = requests.get(url)
    if response.status_code != 200:
        print(f"WARNING: {url} returned {response.status_code}", file=sys.stderr)
        return []
    xml = ElementTree.fromstring(response.text)
    return [v.text for v in xml.find("versioning").find("versions").iter("version")]


def is_supported(version):
    if any(x in version for x in ["rc", "pre", "snapshot"]):
        return False
    # no-moonrise は専用 Javadoc がなく標準 Javadoc とAPI差異があるため除外
    if "no-moonrise" in version:
        return False
    v = version.split("-")[0]
    if v.count(".") == 1:
        v += ".0"
    # adventure-bom が SNAPSHOT を指しておりビルドできないため除外
    if v == "1.20.5":
        return False
    try:
        return semver.match(v, ">=1.16.5")
    except Exception:
        return False


def get_java_version(version):
    v = version.split("-")[0]
    if v.count(".") == 1:
        v += ".0"
    if semver.match(v, "<=1.11.0"):
        return "8"
    elif semver.match(v, "<=1.16.4"):
        return "11"
    elif semver.match(v, "<=1.16.5"):
        return "16"
    else:
        return "21"


def check_javadoc(version):
    """Javadoc が存在するか確認し、使用する javadoc バージョン文字列を返す。
    別バージョンにリダイレクトされる場合は専用 Javadoc がないとみなし None を返す。"""
    v = version.split("-")[0]
    r = requests.get(f"https://jd.papermc.io/paper/{v}/")
    if r.status_code == 200:
        # リダイレクト後の実際のURLバージョンを確認
        actual = r.url.rstrip("/").split("/")[-1]
        # 別バージョンにリダイレクトされた場合は専用 Javadoc なし → スキップ
        if actual != v:
            return None
        soup = BeautifulSoup(r.text, "html.parser")
        h1 = soup.find("h1")
        if h1 and v in h1.text:
            return v
    return None


def get_all_versions():
    versions = []

    # com.destroystokyo.paper (旧 groupId: 1.16.x まで)
    for v in get_maven_versions(
        "https://repo.papermc.io/repository/maven-public/com/destroystokyo/paper/paper-api/maven-metadata.xml"
    ):
        if not is_supported(v):
            continue
        javadoc = check_javadoc(v)
        if javadoc is None:
            print(f"SKIP (no javadoc): {v}")
            continue
        versions.append({
            "groupId": "com.destroystokyo.paper",
            "version": v,
            "javadoc_version": javadoc,
            "java_version": get_java_version(v),
        })

    # io.papermc.paper (新 groupId: 1.17 以降)
    for v in get_maven_versions(
        "https://repo.papermc.io/repository/maven-public/io/papermc/paper/paper-api/maven-metadata.xml"
    ):
        if not is_supported(v):
            continue
        javadoc = check_javadoc(v)
        if javadoc is None:
            print(f"SKIP (no javadoc): {v}")
            continue
        versions.append({
            "groupId": "io.papermc.paper",
            "version": v,
            "javadoc_version": javadoc,
            "java_version": get_java_version(v),
        })

    return versions


def clean_listeners():
    """listeners ディレクトリを .gitkeep だけ残してクリーンアップ"""
    for f in os.listdir(LISTENERS_DIR):
        if f == ".gitkeep":
            continue
        os.remove(os.path.join(LISTENERS_DIR, f))


def generate_listeners(javadoc_version):
    """get-events.py を実行してリスナーファイルを生成"""
    result = subprocess.run(
        [sys.executable, "tools/get-events.py", javadoc_version],
        capture_output=True, text=True
    )
    if result.returncode != 0:
        print(f"  ERROR: get-events.py failed:\n{result.stderr}")
        return False
    count = len([f for f in os.listdir(LISTENERS_DIR) if f.endswith(".java")])
    print(f"  Generated {count} listener files")
    return True


def build(version_info):
    """Maven でビルドを実行"""
    env = os.environ.copy()
    env["JAVA_HOME"] = JAVA_HOME
    env["PATH"] = f"{JAVA_HOME}/bin:{os.path.expanduser('~/tools/apache-maven-3.9.9/bin')}:{env['PATH']}"

    cmd = [
        MVN, "package",
        f"-Djava.version={version_info['java_version']}",
        f"-Dpapermc.groupId={version_info['groupId']}",
        f"-Dpapermc.version={version_info['version']}",
        "-q",  # 出力を抑制
    ]

    result = subprocess.run(cmd, capture_output=True, text=True, env=env)
    if result.returncode != 0:
        print(f"  ERROR: Maven build failed:")
        # エラー行だけ表示
        for line in result.stdout.splitlines():
            if "[ERROR]" in line:
                print(f"    {line}")
        return False
    return True


def main():
    print("=== バージョン一覧の取得 ===")
    versions = get_all_versions()
    print(f"\n対象バージョン数: {len(versions)}")
    for v in versions:
        print(f"  {v['version']} (groupId: {v['groupId']}, java: {v['java_version']}, javadoc: {v['javadoc_version']})")

    results = {"success": [], "failed": []}

    for i, v in enumerate(versions, 1):
        version_str = v["version"]
        print(f"\n[{i}/{len(versions)}] {version_str}")

        # リスナーファイルのクリーンアップ
        print("  Cleaning listeners...")
        clean_listeners()

        # リスナーファイルの生成
        print(f"  Generating listeners from javadoc {v['javadoc_version']}...")
        if not generate_listeners(v["javadoc_version"]):
            results["failed"].append(version_str)
            continue

        # ビルド
        print(f"  Building (Java {v['java_version']})...")
        if build(v):
            jar = f"target/EventFinder-0.0.0-{version_str}.jar"
            size = os.path.getsize(jar) // 1024 if os.path.exists(jar) else 0
            print(f"  SUCCESS: {jar} ({size} KB)")
            results["success"].append(version_str)
        else:
            results["failed"].append(version_str)

    print("\n=== ビルド結果 ===")
    print(f"成功: {len(results['success'])} バージョン")
    for v in results["success"]:
        print(f"  OK  {v}")
    if results["failed"]:
        print(f"失敗: {len(results['failed'])} バージョン")
        for v in results["failed"]:
            print(f"  NG  {v}")

    return 0 if not results["failed"] else 1


if __name__ == "__main__":
    sys.exit(main())
