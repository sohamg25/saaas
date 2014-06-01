#!/bin/bash

SRC=$1

PROFILER="java -cp /home/user/workspace/javaProfiler/lib/*:/home/user/workspace/javaProfiler/bin/:/usr/lib/jvm/java-6-openjdk-amd64/jre/lib/*: profiler.Main"

is_jar() {
	echo $1 | grep ".jar$" > /dev/null
}

if is_jar "$SRC"; then
	INSTR_SRC=`echo $SRC | sed s:.jar:.instr.jar:`
	ORG_PROFILE=`echo $INSTR_SRC | sed s:.jar:_profile.txt:`
	OBF_SRC=`echo $SRC | sed s:.jar:.obf.jar:`
	INSTR_OBF=`echo $OBF_SRC | sed s:.jar:.instr.jar:`
	OBF_PROFILE=`echo $INSTR_OBF | sed s:.jar:_profile.txt:`
else
	INSTR_SRC=`echo $SRC | sed s:$:_instr:`
	ORG_PROFILE=`echo $INSTR_SRC | sed s:$:_profile.txt:`
	OBF_SRC=`echo $SRC | sed s:$:_obf:`
	INSTR_OBF=`echo $OBF_SRC | sed s:$:_instr:`
	OBF_PROFILE=`echo $INSTR_OBF | sed s:$:_profile.txt:`
fi


#profiler_command="$PROFILER -doexception -i \"$SRC\" -o \"$INSTR_SRC\""
#$profiler_command

#profiler_command="$PROFILER -doexception -i \"$OBF_SRC\" -o \"$INSTR_OBF\""
#$profiler_command

OBF_PROFILE_TRANSLATED=`echo $OBF_PROFILE | sed s:.txt:_translated.txt:`

java -jar $INSTR_SRC 2> $ORG_PROFILE &&
java -jar $INSTR_OBF 2> $OBF_PROFILE &&

java -cp /home/user/workspace/javaProfiler/lib/*:/home/user/workspace/saaas/bin/:/home/user/workspace/javaProfiler/bin/: profiler.remap.ProfilerOutputTranslator $OBF_PROFILE /tmp/proguard_map.txt $OBF_PROFILE_TRANSLATED &&

DIFF=diff $ORG_PROFILE $OBF_PROFILE_TRANSLATED &&
echo $DIFF
