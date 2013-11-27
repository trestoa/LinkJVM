#!/bin/sh
rm *.cxx
rm ../java/io/github/linkjvm/jni/*.java
for f in *.i; do
	dirname=`echo "$f" | cut -d'.' -f1`
	if [ ! -d "../java/io/github/linkjvm/jni/$dirname" ]; then
		swig -c++ -package io.github.linkjvm.jni -outdir ../java/io/github/linkjvm/jni -java $f
	else
		rm ../java/io/github/linkjvm/jni/$dirname/*.java
		swig -c++ -package io.github.linkjvm.jni.$dirname -outdir ../java/io/github/linkjvm/jni/$dirname -java $f
	fi
done
	