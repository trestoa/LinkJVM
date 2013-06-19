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

public class Hsv {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected Hsv(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Hsv obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        LinkJVMJNI.delete_Hsv(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setH(short value) {
    LinkJVMJNI.Hsv_h_set(swigCPtr, this, value);
  }

  public short getH() {
    return LinkJVMJNI.Hsv_h_get(swigCPtr, this);
  }

  public void setS(short value) {
    LinkJVMJNI.Hsv_s_set(swigCPtr, this, value);
  }

  public short getS() {
    return LinkJVMJNI.Hsv_s_get(swigCPtr, this);
  }

  public void setV(short value) {
    LinkJVMJNI.Hsv_v_set(swigCPtr, this, value);
  }

  public short getV() {
    return LinkJVMJNI.Hsv_v_get(swigCPtr, this);
  }

  public Hsv() {
    this(LinkJVMJNI.new_Hsv(), true);
  }

}
