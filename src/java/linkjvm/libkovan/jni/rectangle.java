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

public class rectangle {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected rectangle(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(rectangle obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        LinkJVMJNI.delete_rectangle(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setUlx(int value) {
    LinkJVMJNI.rectangle_ulx_set(swigCPtr, this, value);
  }

  public int getUlx() {
    return LinkJVMJNI.rectangle_ulx_get(swigCPtr, this);
  }

  public void setUly(int value) {
    LinkJVMJNI.rectangle_uly_set(swigCPtr, this, value);
  }

  public int getUly() {
    return LinkJVMJNI.rectangle_uly_get(swigCPtr, this);
  }

  public void setWidth(int value) {
    LinkJVMJNI.rectangle_width_set(swigCPtr, this, value);
  }

  public int getWidth() {
    return LinkJVMJNI.rectangle_width_get(swigCPtr, this);
  }

  public void setHeight(int value) {
    LinkJVMJNI.rectangle_height_set(swigCPtr, this, value);
  }

  public int getHeight() {
    return LinkJVMJNI.rectangle_height_get(swigCPtr, this);
  }

  public rectangle() {
    this(LinkJVMJNI.new_rectangle(), true);
  }

}
