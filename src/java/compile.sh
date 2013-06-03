#!/bin/sh

JAVAC="JIKE"

mkdir bin
echo "reading class_list..."
classes=`cat class_list`
echo "compiling Java sources..."
$JAVAC -d bin $classes
echo "compiling Java programm for generating jar archive..."
$JAVAC Generate.java
echo "generating jar archive..."
cd bin
/usr/local/LinkJVM/jvm/jamvm/bin/jamvm ../Generate
mv LinkJVM.jar ..
echo "generated LinkJVM.jar!"