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

public class Rgb {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected Rgb(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Rgb obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        LinkJVMJNI.delete_Rgb(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setR(short value) {
    LinkJVMJNI.Rgb_r_set(swigCPtr, this, value);
  }

  public short getR() {
    return LinkJVMJNI.Rgb_r_get(swigCPtr, this);
  }

  public void setG(short value) {
    LinkJVMJNI.Rgb_g_set(swigCPtr, this, value);
  }

  public short getG() {
    return LinkJVMJNI.Rgb_g_get(swigCPtr, this);
  }

  public void setB(short value) {
    LinkJVMJNI.Rgb_b_set(swigCPtr, this, value);
  }

  public short getB() {
    return LinkJVMJNI.Rgb_b_get(swigCPtr, this);
  }

  public Rgb() {
    this(LinkJVMJNI.new_Rgb(), true);
  }

}
