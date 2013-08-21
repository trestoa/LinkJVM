INSTALLATION=/usr/local/LinkJVM
ECJ_JAR=ecj-3.7.jar

default: dist

dist: ant

init:
	echo "initializing installation..."
	rm -r /usr/bin/java /usr/bin/jamvm /usr/share/jamvm /usr/local/LinkJVM
	mkdir $(INSTALLATION) $(INSTALLATION)/lib $(INSTALLATION)/bin $(INSTALLATION)/share $(INSTALLATION)/include $(INSTALLATION)/etc 
	

javac: init
	echo "installing java compiler..."
	mkdir $(INSTALLATION)/lib/javac
	cp  javac/$(ECJ_JAR) $(INSTALLATION)/lib/javac/
	cd javac; gcc -o javac javac.c
	cp javac/javac $(INSTALLATION)/bin/	
	

classpath: javac 

jvm: classpath

ant: javac
