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
mkdir /usr/local
mkdir /usr/local/LinkJVM
cp -r * /usr/local/LinkJVM
cd /usr/local/LinkJVM/
echo "[INSTALL] add permanent environment variables..."
echo "export BOOTCLASSPATH=/usr/local/LinkJVM/share/jamvm/classes.zip:/usr/local/LinkJVM/share/classpath/glibj.zip:/usr/local/LinkJVM/lib/LinkJVM.jar" >> /etc/profile
echo "export LD_LIBRARY_PATH=/usr/local/LinkJVM/lib/classpath" >> /etc/profile
echo "export CLASSPATH=/usr/local/LinkJVM/share/jamvm/classes.zip:/usr/local/LinkJVM/share/classpath/glibj.zip:/usr/local/LinkJVM/lib/LinkJVM.jar:." >> /etc/profile
echo "[INSTALL] setting jamvm symlink..."
ln -s /usr/local/LinkJVM/bin/jamvm /usr/bin/jamvm
ln -s /usr/local/LinkJVM/bin/jamvm /usr/bin/java
echo "[INSTALL] cleaning up directory: deleting install script..."
rm /usr/local/LinkJVM/install.sh
echo "[INSTALL] Installation complete! LinkJVM installed!"
