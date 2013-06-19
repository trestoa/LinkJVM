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



package linkjvm.libkovan.jni;

public class point2 {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected point2(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(point2 obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        LinkJVMJNI.delete_point2(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setX(int value) {
    LinkJVMJNI.point2_x_set(swigCPtr, this, value);
  }

  public int getX() {
    return LinkJVMJNI.point2_x_get(swigCPtr, this);
  }

  public void setY(int value) {
    LinkJVMJNI.point2_y_set(swigCPtr, this, value);
  }

  public int getY() {
    return LinkJVMJNI.point2_y_get(swigCPtr, this);
  }

  public point2() {
    this(LinkJVMJNI.new_point2(), true);
  }

}
