#Building and Installing LinkJVM
The on the KIPR Link pre-installed [Jikes Java-Compiler](http://jikes.sourceforge.net/) has given me a lot of problems(since the last release was in 2005) especially with generics and Java 1.5 features. Therefore the built process has two parts. The first part happens on your PC and compiles the Java part of LinkJVM(building LinkJVM.jar). The second part is responsible for the native part and happens directly on the KIPR Link. 

##Prerequisites
+ And kind of JDK
+ Linux or Mac OS X

##Step 1 - Building LinkJVM.jar
Is mentioned before the first step happens on your PC and builds the Java-Part of LinkJVM.
Just open your Shell and run the `installstep1.sh`. This script will automatically build LinkJVM.jar. 

##Step 2 - Prepare for the second part
Copy the hole LinkJVM Repository directory on a flash drive.
Insert the flash drive into the Link
Of course you can also upload the directory using SFTP or SCP.
Connect via SSH to you Link (user == root, password == NULL)
cd to `linkjvmdirectory/install`

## Step 3 - Run second part and clean up installation
type `sh install.sh`
LinkJVM installation is finished! :-)
You can delete the LinkJVM directory on the flash drive.
Have fun and code Java!
