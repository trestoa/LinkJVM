#!/bin/sh
#
# This file is part of LinkJVM.
#
# Java Framework for the KIPR Link
# Copyright (C) 2013 Markus Klein <m@mklein.co.at>
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program. If not, see <http://www.gnu.org/licenses/>.
#

echo "[INSTALL] Installing LinkJVM..."
echo "[INSTALL] deleting pre-installed java and previous installations..."
rm -r /usr/bin/java /usr/bin/jamvm /usr/share/jamvm /usr/local/LinkJVM
echo "[INSTALL] copying files..."
mkdir /usr/local/LinkJVM
cd ..
cp * /usr/local/LinkJVM
cd /usr/local/LinkJVM/
echo "[INSTALL] making new directories..."
mkdir include
mkdir bin
mkdir lib
mkdir share
cd src/jni/
echo "[INSTALL] compiling native JNI wrapper..."
echo "[COMPILE] compiling libkovan_wrap.c..."
gcc -c -I /usr/local/LinkJVM/jvm/classpath/include libkovan_wrap.c
echo "[COMPILE] linking libkovan_wrap.o with libkovan.so"
ld -G libkovan_wrap.c /usr/lib/libkovan.so -o LinkJVM.so
echo "[COMPILE] libkovanjava.so created!"
echo "[INSTALL] compiling java files and generating jar archive..."
sh /usr/local/LinkJVM/src/java/compile.sh
echo "[INSTALL] moving LinkJVM.so into /usr/local/LinkJVM/lib/ ..."
mv /usr/local/LinkJVM/src/jni/LinkJVM.so /usr/local/LinkJVM/lib/LinkJVM.so
echo "[INSTALL] moving LinkJVM.jar into /usr/local/LinkJVM/lib/ ..."
mv /usr/local/LinkJVM/src/java/LinkJVM.jar /usr/local/LinkJVM/lib
echo "[INSTALL] moving jamvm files..."
mv /bin/local/LinkJVM/jvm/jamvm/bin/jamvm /usr/local/LinkJVM/bin/jamvm
mv /bin/local/LinkJVM/jvm/jamvm/share/* /usr/local/LinkJVM/share/
mv /bin/local/LinkJVM/jvm/jamvm/include/* /usr/local/LinkJVM/include/
mv /bin/local/LinkJVM/jvm/jamvm/lib/* /usr/local/LinkJVM/lib/
echo "[INSTALL] moving classpath files..."
mv /bin/local/LinkJVM/jvm/jamvm/share/* /usr/local/LinkJVM/share/
mv /bin/local/LinkJVM/jvm/jamvm/include/* /usr/local/LinkJVM/include/
mv /bin/local/LinkJVM/jvm/jamvm/share/* /usr/local/LinkJVM/share/
echo "[INSTALL] deleting sources and unused files..."
rm -r src swig jvm install
echo "[INSTALL] installation complete! LinkJVM installed! Please run HelloWorld to check installation."
