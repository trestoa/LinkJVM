/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.linkjvm.libkovan;

public class AccelZ {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected AccelZ(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AccelZ obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        LinkJVMJNI.delete_AccelZ(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public short value() {
    return LinkJVMJNI.AccelZ_value(swigCPtr, this);
  }

  public AccelZ() {
    this(LinkJVMJNI.new_AccelZ(), true);
  }

}