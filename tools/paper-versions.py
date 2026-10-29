"""1.16.5 以降で STABLE ビルドを持つ全 Paper バージョンから、スモークテスト用の GitHub Actions マトリクス (JSON) を出力する。"""
import json
import re
import time
import urllib.error
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


def fetch(path):
    for attempt in range(3):
        try:
            with urllib.request.urlopen("https://fill.papermc.io/v3/projects/paper" + path, timeout=30) as res:
                return json.load(res)
        except (urllib.error.URLError, TimeoutError):
            if attempt == 2:
                raise
            time.sleep(5)


def has_stable_build(version):
    return any(b["channel"] == "STABLE" for b in fetch(f"/versions/{version}/builds"))


def main():
    groups = fetch("")["versions"]

    stable = sorted(
        (v for g in groups.values() for v in g if re.fullmatch(r"\d+(\.\d+)+", v) and parse(v) >= OLDEST),
        key=parse,
    )
    if not stable:
        raise SystemExit("No Paper versions found")

    targets = [v for v in stable if has_stable_build(v)]
    print(json.dumps({"include": [{"version": v, "java": java_version(v)} for v in targets]}))


main()
