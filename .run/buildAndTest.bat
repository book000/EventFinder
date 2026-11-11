@echo off
set PLUGIN_NAME=EventFinder
set JAR_FILE=eventfinder-*.jar

if not exist run (
    mkdir run
)

if not exist run\eula.txt (
    echo eula=true> run\eula.txt
)

if not exist run\plugins (
    mkdir run\plugins
)

if not exist run\paper.jar (
    curl -o run\paper.jar -L "https://papermc.io/api/v1/paper/1.16.5/latest/download"
)

if not exist run\mcrconapi-1.1.1.jar (
    curl -o run\mcrconapi-1.1.1.jar -L "https://github.com/fnetworks/mcrconapi/releases/download/v1.1.1/mcrconapi-1.1.1.jar"
)

if not exist run\server.properties (
    echo server.properties does not exist, creating it.
    echo gamemode=creative> run/server.properties
    echo enforce-whitelist=true>> run/server.properties
    echo difficulty=peaceful>> run/server.properties
    echo level-type=flat>> run/server.properties
    echo enable-command-block=true>> run/server.properties
    echo server-port=25565>> run/server.properties
    echo enable-rcon=true>> run/server.properties
    echo rcon.password=rconpassword>> run/server.properties
    echo rcon.port=25575>> run/server.properties
    echo white-list=true>> run/server.properties
    echo motd=%PLUGIN_NAME% Test Server>> run/server.properties
)

echo Copying the jar file.
copy target\%JAR_FILE% run\plugins\%JAR_FILE%
if not %errorlevel% == 0 (
    echo %JAR_FILE% NOT FOUND

    echo Closing in 5 seconds.
    timeout 5 /NOBREAK
    exit 1
)

echo Sending the reload command to the Minecraft server.
java -jar run\mcrconapi-1.1.1.jar -a localhost -l rconpassword -n -c "rl confirm"

if not %errorlevel% == 0 (
    echo The Minecraft server is not running, starting it.

    cd run
    java -jar paper.jar -nogui
    if %errorlevel% == 0 exit
)

echo Closing in 5 seconds.
timeout 5 /NOBREAK
exit
