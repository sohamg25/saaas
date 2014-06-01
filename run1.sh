#!/bin/bash

SRC=$1
shift
LIBS=$@

PROGUARD="java -classpath /home/shashi/workspace/saaas/bin/: proguard.ProGuard"
REMAP="java -cp /home/shashi/workspace/saaas/bin:/home/shashi/workspace/saaas/lib/* proguard.remap.XMLTranslator"
DIFF="java -cp /home/shashi/workspace/saaas/bin:/home/shashi/workspace/saaas/lib/* proguard.remap.XMLDiff"

JD_GUI=/home/soham/M.E\ Project/jd-gui/jd-gui
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
$proguard_command &&

if is_jar "$SRC"; then 
	$JD_GUI "$SRC" "$DEST" 2> /dev/null &
else
	$JD_GUI "$SRC"/* "$DEST"/*  2> /dev/null &
fi

rm /tmp/bugreport_*
echo Running findbugs on original code.
findbugs_command="$FINDBUGS -textui -effort:min -xml -output /tmp/bugreport_original1.xml $SRC" &&

$findbugs_command                   
echo Running findbugs on obfuscated code
findbugs_command="$FINDBUGS -textui -effort:min -xml -output /tmp/bugreport_obfuscated1.xml $DEST" &&
$findbugs_command

echo Converting report on obfuscated file.
$REMAP /tmp/bugreport_obfuscated1.xml /tmp/proguard_map1.txt /tmp/new_report1.xml &&

sudo $DIFF /tmp/bugreport_original1.xml /tmp/new_report1.xml /tmp/missing1.xml /tmp/extra1.xml

$FINDBUGS /tmp/extra1.xml &
$FINDBUGS /tmp/missing1.xml &
