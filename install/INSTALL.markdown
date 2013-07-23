#Building and Installing LinkJVM
The on the KIPR Link pre-installed [Jikes Java-Compiler](http://jikes.sourceforge.net/) has given me a lot of problems(since the last release was in 2005) especially with generics and Java 1.5 features. Therefore the built process has two parts. The first part happens on your PC and compiles the Java part of LinkJVM(building LinkJVM.jar). The second part is responsible for the native part and happens directly on the KIPR Link. 

##Prerequisites
+ And kind of JDK on your PC
+ Possibility to run shell scripts(Linux or Mac OS X(or Windows :-( with Cygwin)
+ SSH Client
+ SFTP Client or Flash Drive

##Step 1 - Building LinkJVM.jar
Is mentioned before the first step happens on your PC and builds the Java-Part of LinkJVM.
