#!/bin/bash
# 指定バージョンの Paper を起動し、EventFinder が有効化されてイベントを表示することを確認する。
# 使い方: [JAVA=<java コマンド>] tools/smoke-test.sh <Paper version> <EventFinder jar>
set -euo pipefail

version=$1
plugin_jar=$(realpath "$2")
work=$(mktemp -d)
trap 'rm -rf "$work"' EXIT
cd "$work"

build=$(curl -fsS "https://fill.papermc.io/v3/projects/paper/versions/${version}/builds/latest")
url=$(jq -r '.downloads["server:default"].url' <<<"$build")
sha256=$(jq -r '.downloads["server:default"].checksums.sha256' <<<"$build")
curl -fsS -o paper.jar "$url"
echo "${sha256}  paper.jar" | sha256sum -c -

mkdir plugins
cp "$plugin_jar" plugins/EventFinder.jar
echo "eula=true" > eula.txt
printf 'online-mode=false\nlevel-type=minecraft\\:flat\ngenerate-structures=false\nview-distance=2\n' > server.properties

mkfifo stdin
exec 3<>stdin
timeout 600 "${JAVA:-java}" -Xmx1G -jar paper.jar --nogui <&3 > log.txt 2>&1 &
server=$!

for _ in $(seq 1 240); do
    grep -q 'Done (' log.txt && break
    kill -0 "$server" 2>/dev/null || break
    sleep 2
done
grep -q 'Done (' log.txt || { echo "Server did not start"; tail -50 log.txt; exit 1; }

echo "event list" >&3
sleep 5
echo "stop" >&3
wait "$server" || { echo "Server exited abnormally"; tail -50 log.txt; exit 1; }

sed -E 's/\x1b\[[0-9;]*m//g' log.txt > clean.txt
errors='Could not pass event|Register failed|Failed to register|Error occurred while enabling EventFinder|Legacy plugin EventFinder'
fail=0
grep -q 'Enabling EventFinder' clean.txt || { echo "FAIL: plugin was not enabled"; fail=1; }
grep -qE '^\[[0-9:]+ INFO\]: ServerLoadEvent' clean.txt || { echo "FAIL: no event was displayed (ServerLoadEvent)"; fail=1; }
grep -q 'hidden conditions' clean.txt || { echo "FAIL: /event list did not respond"; fail=1; }
if grep -qE "$errors" clean.txt; then
    echo "FAIL: plugin error or warning in log"
    grep -E "$errors" clean.txt | head
    fail=1
fi
[ "$fail" = 0 ] && echo "OK: Paper ${version}"
exit "$fail"
