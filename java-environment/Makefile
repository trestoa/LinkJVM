INSTALLATION=/usr/local/LinkJVM
ECJ_JAR=ecj-3.7.jar

default: dist

dist: ant

init:
	echo "initializing installation..."
	rm -r /usr/bin/java /usr/bin/jamvm /usr/share/jamvm /usr/local/LinkJVM /usr/bin/javac
	mkdir $(INSTALLATION) $(INSTALLATION)/lib $(INSTALLATION)/bin $(INSTALLATION)/share $(INSTALLATION)/include $(INSTALLATION)/etc 
	

javac: init
	echo "installing java compiler..."
	mkdir $(INSTALLATION)/lib/javac
	cp  javac/$(ECJ_JAR) $(INSTALLATION)/lib/javac/
	cd javac; gcc -o javac javac.c
	cp javac/javac $(INSTALLATION)/bin/	
	ln -s $(INSTALLATION)/bin/javac /usr/bin/javac
	ln -s $(INSTALLATION)/bin/javac /usr/bin/ecj

classpath: javac 
	echo "installing gnu classpath..."
	cp -r classpath/* $(INSTALLATION)/

jvm: classpath
	echo "installing jvm..."
	cp -r jamvm/* $(INSTALLATION)/
	ln -s $(INSTALLATION)/bin/jamvm /usr/bin/java
	ln -s $(INSTALLATION)/bin/jamvm /usr/bin/jamvm
	last_row = `sed -e '/^[<blank><tab>]*$/d'  | sed -n -e '$p'`; if last_row = 'sh /usr/local/LinkJVM/etc/environment-vars.sh'; then 'sh /usr/local/LinkJVM/etc/environment-vars.sh' >> /etc/profile; fi;
	

ant: javac
