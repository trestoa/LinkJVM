/*
* This file is part of LinkJVM.
*
* Java Framework for the KIPR Link
* Copyright (C) 2013 Markus Klein <m@mklein.co.at>
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*/

%module linkjvm_accel
%{
    #include "include/kovan/sensor.hpp"
    #include "include/kovan/accel.hpp"
%}

%import "sensors.i"
%typemap("javaimports") AccelX "import linkjvm.low.sensors.ShortSensor;";
%typemap("javaimports") AccelY "import linkjvm.low.sensors.ShortSensor;";
%typemap("javaimports") AccelZ "import linkjvm.low.sensors.ShortSensor;";

class Acceleration{
	public:
        static short x();
        static short y();
        static short z();
        static bool calibrate();
	private:
        static void setupI2C();
        static bool s_setup;
};

class AccelX : public Sensor<short>{
	public:
        virtual short value() const;
};

class AccelY : public Sensor<short>{
	public:
        virtual short value() const;
};

class AccelZ : public Sensor<short>{
	public:
        virtual short value() const;
};