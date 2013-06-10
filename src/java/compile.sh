#!/bin/sh

JAVAC="jikes -source 1.5 -classpath /usr/local/LinkJVM/jvm/classpath/share/classpath/glibj.zip"

cd /usr/local/LinkJVM/src/java
mkdir bin
echo "reading class_list..."
classes=`cat class_list`
echo "compiling Java sources..."
$JAVAC -d bin $classes
echo "compiling Java programm for generating jar archive..."
$JAVAC GenerateJar.java
echo "generating jar archive..."
mv GenerateJar.class bin
cd bin
/usr/local/LinkJVM/jvm/jamvm/bin/jamvm GenerateJar
mv LinkJVM.jar ..
echo "generated LinkJVM.jar!"