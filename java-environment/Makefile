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


INSTALLATION=/usr/local/LinkJVM
ECJ_JAR=ecj-3.7.jar

default: dist

dist:
	make init
	make javac
	make classpath
	make jvm
	#make ant 
	echo "LinkJVM java environment installed!"

init:
	echo "initializing installation..."
	rm -r /usr/bin/java /usr/bin/jamvm /usr/share/jamvm /usr/local/LinkJVM /usr/bin/javac
	mkdir $(INSTALLATION) $(INSTALLATION)/lib $(INSTALLATION)/bin $(INSTALLATION)/share $(INSTALLATION)/include $(INSTALLATION)/etc 
	

javac: 
	echo "installing java compiler..."
	mkdir $(INSTALLATION)/lib/javac
	cp  javac/$(ECJ_JAR) $(INSTALLATION)/lib/javac/
	cd javac; gcc -o javac javac.c
	cp javac/javac $(INSTALLATION)/bin/	
	ln -s $(INSTALLATION)/bin/javac /usr/bin/javac
	ln -s $(INSTALLATION)/bin/javac /usr/bin/ecj

classpath:
	echo "installing gnu classpath..."
	cp -r classpath/* $(INSTALLATION)/

jvm:
	echo "installing jvm..."
	cp -r jamvm/* $(INSTALLATION)/
	ln -s $(INSTALLATION)/bin/jamvm /usr/bin/java
	ln -s $(INSTALLATION)/bin/jamvm /usr/bin/jamvm
	last_row = `sed -e '/^[<blank><tab>]*$/d'  | sed -n -e '$p'`; if last_row = 'sh /usr/local/LinkJVM/etc/environment-vars.sh'; then 'sh /usr/local/LinkJVM/etc/environment-vars.sh' >> /etc/profile; fi;
	

#ant:
