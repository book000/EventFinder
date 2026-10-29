"""Paper の安定版一覧から、スモークテスト用の GitHub Actions マトリクス (JSON) を出力する。

使い方: python tools/paper-versions.py <first|all>
  first: 最古 (1.16.5) と最新の安定版のみ
  all:   1.16.5 以降の全安定版
"""
import json
import re
import sys
import urllib.request

OLDEST = (1, 16, 5)


def parse(version):
    return tuple(int(x) for x in version.split("."))


def java_version(version):
    # https://docs.papermc.io/paper/getting-started#requirements
    v = parse(version)
    if v <= (1, 16, 5):
        return "8"
    if v <= (1, 17, 1):
        return "16"
    if v < (1, 20, 5):
        return "17"
    if v < (26, 0, 0):
        return "21"
    return "25"


def main():
    mode = sys.argv[1]
    with urllib.request.urlopen("https://fill.papermc.io/v3/projects/paper", timeout=30) as res:
        groups = json.load(res)["versions"]

    stable = sorted(
        (v for g in groups.values() for v in g if re.fullmatch(r"\d+(\.\d+)+", v) and parse(v) >= OLDEST),
        key=parse,
    )
    if not stable:
        raise SystemExit("No stable Paper versions found")

    targets = [stable[0], stable[-1]] if mode == "first" else stable
    print(json.dumps({"include": [{"version": v, "java": java_version(v)} for v in dict.fromkeys(targets)]}))


main()
