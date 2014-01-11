#LinkJVM 
Java on the KIPR Link


##About LinkJVM
LinkJVM is a Java Environment of the [KIPR Link](http://www.kipr.org/products/link/) and allows the execution of very Java language and acually very JVM supported language such as Scala and Javascript (over [Rhino](https://developer.mozilla.org/en/docs/Rhino)).

##Getting LinkJVM
###Building from Source
Building LinkJVM from source is really complex, because it is embedded into KIRP Link´s build system, bitbake:

+ First, you´ll need to [setup the build server](http://bmcdorman.github.io/link/2013/06/13/build-server.html).
+ Add the linkjvm-metalayer [meta-linkjvm](https://github.com/LinkJVM/meta-linkjvm) to the buildserver.
+ Build LinkJVM 

###Download an Firmware-Image with LinkJVM
You can download the latest image from my [fileserver](http://files.mklein.co.at/LinkJVM).

###Using LinkJVM-Installer
Follow the instructions on the LinkJVM-Installer repository.

##Updating LinkJVM
You can update LinkJVM with [LinkJVM-Updater](https://github.com/LinkJVM/LinkJVM-Updater.git).

##Authors and Contact
+ [Markus Klein](https://github.com/kleiinnn): Project Leader, Developer 
+ Chistoph Hackenberger: Developer
+ Klaus Ableitinger: Developer

##License 
This file is part of LinkJVM.

Java Framework for the KIPR Link
Copyright (C) 2014 LinkJVM

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
any later version.
 
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
