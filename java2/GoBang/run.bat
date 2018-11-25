
cls
chcp

cd /d %~dp0

javac -encoding utf-8 goBang.java

java goBang

pause
DEL .\*.class