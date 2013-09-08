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

INSTALLATION_DIR=/usr/local/LinkJVM

function install_linkjvm(){
	rm -r /usr/bin/java /usr/bin/jamvm /usr/share/jamvm /usr/bin/javac /usr/bin/ecj $INSTALLATION_DIR
	mkdir -p $INSTALLATION_DIR
	if [[ $? != 0 ]]; then
		return 1
	fi
	cd ..
	if [[ $? != 0 ]]; then
		return 1
	fi
	cp -r * $INSTALLATION_DIR
	if [[ $? != 0 ]]; then
		return 1
	fi
	ln -s $INSTALLATION_DIR/bin/javac /usr/bin/javac
	if [[ $? != 0 ]]; then
		return 1
	fi
	ln -s $INSTALLATION_DIR/bin/javac /usr/bin/ecj
	if [[ $? != 0 ]]; then
		return 1
	fi
	ln -s $INSTALLATION_DIR/bin/jamvm /usr/bin/java
	if [[ $? != 0 ]]; then
		return 1
	fi
	ln -s $INSTALLATION_DIR/bin/jamvm /usr/bin/jamvm
	if [[ $? != 0 ]]; then
		return 1
	fi
	more /etc/profile | grep "export BOOTCLASSPATH=/usr/local/LinkJVM/share/jamvm/classes.zip:/usr/local/LinkJVM/share/classpath/glibj.zip:/usr/local/LinkJVM/lib/LinkJVM.jar"
	if [[ $? == 1 ]]; then
		echo "export BOOTCLASSPATH=/usr/local/LinkJVM/share/jamvm/classes.zip:/usr/local/LinkJVM/share/classpath/glibj.zip:/usr/local/LinkJVM/lib/LinkJVM.jar" >> /etc/profile
	elif [[ $? < 0  ]]; then
		return 1
	fi
	more /etc/profile | grep "export LD_LIBRARY_PATH=/usr/local/LinkJVM/lib/classpath"
	if [[ $? == 1 ]]; then
		echo "export LD_LIBRARY_PATH=/usr/local/LinkJVM/lib/classpath" >> /etc/profile
	elif [[ $? < 0  ]]; then
		return 1
	fi
	more /etc/profile | grep "export CLASSPATH=/usr/local/LinkJVM/share/jamvm/classes.zip:/usr/local/LinkJVM/share/classpath/glibj.zip:/usr/local/LinkJVM/lib/LinkJVM.jar:."
	if [[ $? == 1 ]]; then
		echo "export CLASSPATH=/usr/local/LinkJVM/share/jamvm/classes.zip:/usr/local/LinkJVM/share/classpath/glibj.zip:/usr/local/LinkJVM/lib/LinkJVM.jar:." >> /etc/profile
	elif [[ $? < 0  ]]; then
		return 1
	fi
	export BOOTCLASSPATH=/usr/local/LinkJVM/share/jamvm/classes.zip:/usr/local/LinkJVM/share/classpath/glibj.zip:/usr/local/LinkJVM/lib/LinkJVM.jar
	if [[ $? != 0 ]]; then
		return 1
	fi
	export LD_LIBRARY_PATH=/usr/local/LinkJVM/lib/classpath
	if [[ $? != 0 ]]; then
		return 1
	fi
	export CLASSPATH=/usr/local/LinkJVM/share/jamvm/classes.zip:/usr/local/LinkJVM/share/classpath/glibj.zip:/usr/local/LinkJVM/lib/LinkJVM.jar:.
	if [[ $? != 0 ]]; then
		return 1
	fi
	return 0
}

echo "[INSTALL] Installing LinkJVM..."
install_linkjvm
if [[ $? != 0 ]]; then
	echo "[ERROR] install_linkjvm returned a non zero status code"
	exit
fi
echo "[INSTALL] LinkJVM java environment installed!"
