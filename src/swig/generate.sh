#!/bin/sh
for f in *.i; do
	dirname=`echo "$f" | cut -d'.' -f1`
	if [ ! -d "../java/io/github/linkjvm/$dirname" ]; then
		swig -c++ -package io.github.linkjvm.jni -outdir ../java/io/github/linkjvm/jni -java $f
	else
		swig -c++ -package io.github.linkjvm.jni.$dirname -outdir ../java/io/github/linkjvm/jni/$dirname -java $f
	fi
done
	
