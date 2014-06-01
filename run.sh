#!/bin/bash

SRC=$1
shift
LIBS=$@

PROGUARD="java -classpath /home/user/workspace/saaas/bin/: proguard.ProGuard"
REMAP="java -cp /home/user/workspace/saaas/bin:/home/user/workspace/saaas/lib/*:. proguard.remap.XMLTranslator"
DIFF="java -cp /home/user/workspace/saaas/bin:/home/user/workspace/saaas/lib/dom4j-1.6.1.jar proguard.remap.XMLDiff"

JD_GUI=./jd-gui/jd-gui
FINDBUGS="findbugs/bin/findbugs"

echo Source: $SRC

is_jar() {
	echo $1 | grep ".jar$" > /dev/null
}

if is_jar "$SRC"; then
	DEST=`echo $SRC | sed s:.jar:.obf.jar:`
else
	DEST=`echo $SRC | sed s:$:_obf:`
fi

echo Cleaning destination.
rm -rf "$DEST"

proguard_command="$PROGUARD
-injars \"$SRC\"
-outjars \"$DEST\"
@proguard.conf
"

for lib in $LIBS; do
	proguard_command="$proguard_command -libraryjars $lib"
done

echo running proguard: $proguard_command
$proguard_command > proguard_output.txt &&

if is_jar "$SRC"; then 
	$JD_GUI "$SRC" "$DEST" 2> /dev/null &
else
	$JD_GUI "$SRC"/* "$DEST"/*  2> /dev/null &
fi

rm /home/user/M.E_Project/saaas/reports/bugreport_*
echo Running findbugs on original code.
findbugs_command="$FINDBUGS -textui -effort:min -xml -output /home/user/M.E_Project/saaas/reports/bugreport_original.xml $SRC" &&

$findbugs_command                   
echo Running findbugs on obfuscated code
findbugs_command="$FINDBUGS -textui -effort:min -xml -output /home/user/M.E_Project/saaas/reports/bugreport_obfuscated.xml $DEST" &&
$findbugs_command

echo Converting report on obfuscated file.
$REMAP /home/user/M.E_Project/saaas/reports/bugreport_obfuscated.xml /tmp/proguard_map.txt /tmp/new_report.xml > remap.txt &&
echo Done Converting report on obfuscated file.

len=$SRC | wc -c
b="\/"
appnd=$SRC | grep -o "$b.*"

$DIFF /home/user/M.E_Project/saaas/reports/bugreport_original.xml /tmp/new_report.xml /home/user/M.E_Project/saaas/reports/missing_tomcat.xml /home/user/M.E_Project/saaas/reports/extra_tomcat.xml

$FINDBUGS /home/user/M.E_Project/saaas/reports/extra_tomcat.xml &
$FINDBUGS /home/user/M.E_Project/saaas/reports/missing_tomcat.xml &
