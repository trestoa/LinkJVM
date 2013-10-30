/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.linkjvm.libkovan;

public class Analog {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected Analog(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Analog obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        LinkJVMJNI.delete_Analog(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public Analog(short port) {
    this(LinkJVMJNI.new_Analog(port), true);
  }

  public int value() {
    return LinkJVMJNI.Analog_value(swigCPtr, this);
  }

  public void setPullup(boolean pullup) {
    LinkJVMJNI.Analog_setPullup(swigCPtr, this, pullup);
  }

  public boolean pullup() {
    return LinkJVMJNI.Analog_pullup(swigCPtr, this);
  }

  public short port() {
    return LinkJVMJNI.Analog_port(swigCPtr, this);
  }

}