#LinkJVM 
##Java on the KIPR Link

##About LinkJVM
LinkJVM is a Java Environment of the [KIPR Link](http://www.kipr.org/products/link/) and allows the execution of very Java language and acually very JVM supported language such as Scala and Javascript (over [Rhino](https://developer.mozilla.org/en/docs/Rhino).

##Java?
####Why is the opportunity to program the robot in Java important?
+ First, the most students in school get started in programming using Java, so they should be able to use the learned skills in botball.
+ Java provides automatic garbage collection and an excellent set of basic data types like lists, maps and so on.
+ Compared to C Java has a much better maintainability especially in very large libraries because of object orientation.

####Isn´t Java much slower than C?
+ No, not much. Of course is Java slower the C, but not that much. In another way: For normal usage it won´t make a difference.

####So are there Benchmarks?
+ No, I have not had the time to generate benchmark for LinkJVM yet, but I plan to make one.

##Robot Library
LinkJVM provides a huge Libray for controlling the robot(reading analog and digital sensor values, controlling motors and servos, ...). This library is acually only a wrapper library for the in native c written [libkovan](https://github.com/kipr/libkovan).

##Event Interfaces
The `linkjvm.events` package is a part of the robot library which provides an fast way and easy way for an event-driven software architecture. It allows to define events and actions triggered by the events.

##YA Drone Integration 
LinkJVM integrates an open source library for controlling the [Parrot AR Drone](http://ardrone2.parrot.com/) named [YA Drone](https://github.com/MahatmaX/YADrone). YA Drone provides a huge library for controlling the drone including listener interfaces.

##Author and Contact
[Markus Klein](https://mklein.co.at)

##License 
This file is part of LinkJVM.

Java Framework for the KIPR Link
Copyright (C) 2013 Markus Klein<m@mklein.co.at>

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
