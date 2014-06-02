#!/bin/bash

SRC=$1
shift
LIBS=$@

PROGUARD="java -classpath /home/soham/workspace/saaas/bin/: proguard.ProGuard"
REMAP="java -cp /home/soham/workspace/saaas/bin:/home/soham/workspace/saaas/lib/*:. proguard.remap.XMLTranslator"
DIFF="java -cp /home/soham/workspace/saaas/bin:/home/soham/workspace/saaas/lib/dom4j-1.6.1.jar proguard.remap.XMLDiff"

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
@proguard1.conf
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

rm /home/soham/M.E_Project/saaas/reports/bugreport_*
echo Running findbugs on original code.
findbugs_command="$FINDBUGS -textui -effort:min -xml -output /home/soham/M.E_Project/saaas/reports/bugreport_original.xml $SRC" &&

$findbugs_command                   
echo Running findbugs on obfuscated code
findbugs_command="$FINDBUGS -textui -effort:min -xml -output /home/soham/M.E_Project/saaas/reports/bugreport_obfuscated.xml $DEST" &&
$findbugs_command

echo Converting report on obfuscated file.
$REMAP /home/soham/M.E_Project/saaas/reports/bugreport_obfuscated.xml /tmp/proguard_map.txt /tmp/new_report.xml > remap.txt &&
echo Done Converting report on obfuscated file.

len=$SRC | wc -c
b="\/"
appnd=$SRC | grep -o "$b.*"

$DIFF /home/soham/M.E_Project/saaas/reports/bugreport_original.xml /tmp/new_report.xml /home/soham/M.E_Project/saaas/reports/missing_tomcat.xml /home/soham/M.E_Project/saaas/reports/extra_tomcat.xml

$FINDBUGS /home/soham/M.E_Project/saaas/reports/extra_tomcat.xml &
$FINDBUGS /home/soham/M.E_Project/saaas/reports/missing_tomcat.xml &
