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

%module linkjvm_analog
%{
    #include "include/kovan/sensor.hpp"
%}

%import "sensors.i"
%typemap("javaimports") Analog "import io.github.linkjvm.jni.sensors.UnsignedShortSensor;";

class  Analog : public Sensor<unsigned short>{
	public:
		Analog(const unsigned char& port);
		virtual unsigned short value() const;
		virtual void setPullup(bool pullup);
		virtual bool pullup() const;
		unsigned char port() const;

	private:
		unsigned char m_port;
};

class  Analog8 : public Analog{
	public:
		Analog8(const unsigned char& port);
		virtual unsigned short value() const;
};