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

public class pixel {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected pixel(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(pixel obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        LinkJVMJNI.delete_pixel(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setR(int value) {
    LinkJVMJNI.pixel_r_set(swigCPtr, this, value);
  }

  public int getR() {
    return LinkJVMJNI.pixel_r_get(swigCPtr, this);
  }

  public void setG(int value) {
    LinkJVMJNI.pixel_g_set(swigCPtr, this, value);
  }

  public int getG() {
    return LinkJVMJNI.pixel_g_get(swigCPtr, this);
  }

  public void setB(int value) {
    LinkJVMJNI.pixel_b_set(swigCPtr, this, value);
  }

  public int getB() {
    return LinkJVMJNI.pixel_b_get(swigCPtr, this);
  }

  public pixel() {
    this(LinkJVMJNI.new_pixel(), true);
  }

}
