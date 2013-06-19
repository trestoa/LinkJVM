/*
* This file is part of LinkJVM.
*
* Java Framework for the KIPR Link
* Copyright (C) 2013 Markus Klein<m@mklein.co.at>
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

/*
* IMPORTANT!!!
* Do not make changes to this file unless you know what you are doing--modify
* the SWIG interface file instead.
*/



package libkovan.jni;

public class SWIGTYPE_p_unsigned_char {
  private long swigCPtr;

  protected SWIGTYPE_p_unsigned_char(long cPtr, boolean futureUse) {
    swigCPtr = cPtr;
  }

  protected SWIGTYPE_p_unsigned_char() {
    swigCPtr = 0;
  }

  protected static long getCPtr(SWIGTYPE_p_unsigned_char obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }
}

