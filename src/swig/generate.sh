#!/bin/sh
rm ../jni/*.cxx
rm ../java/linkjvm/low/*.java
for f in *.i; do
	dirname=`echo "$f" | cut -d'.' -f1`
	if [ ! -d "../java/linkjvm/low/$dirname" ]; then
		swig -c++ -package linkjvm.low -outdir ../java/linkjvm/low/ -java $f
	else
		rm ../java/linkjvm/low/$dirname/*.java
		swig -c++ -package linkjvm.low.$dirname -outdir ../java/linkjvm/low/$dirname -java $f
	fi
done
mv *.cxx ../jni/
	
