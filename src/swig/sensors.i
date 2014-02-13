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

%module linkjvm_sensor
%{
    #include "include/kovan/sensor.hpp"
%}

%typemap(javabody) Sensor %{
  private long swigCPtr;
  protected boolean swigCMemOwn;

  public $javaclassname(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr($javaclassname obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }
%}

template<typename T> class  Sensor{
	public:
		virtual ~Sensor() {}
		virtual T value() const = 0;
};

/* Sensor instantaions */
%template(IntSensor) Sensor<int>;
%template(UnsignedShortSensor) Sensor<unsigned short>;
%template(ShortSensor) Sensor<short>;
%template(BoolSensor) Sensor<bool>;
%template(UnsignedCharSensor) Sensor<unsigned char>;
%template(CharSensor) Sensor<char>;

