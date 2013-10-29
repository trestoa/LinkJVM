/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.linkjvm.libkovan;

public class Digital {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected Digital(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Digital obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        LinkJVMJNI.delete_Digital(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public Digital(short port) {
    this(LinkJVMJNI.new_Digital(port), true);
  }

  public void setValue(boolean value) {
    LinkJVMJNI.Digital_setValue(swigCPtr, this, value);
  }

  public boolean value() {
    return LinkJVMJNI.Digital_value(swigCPtr, this);
  }

  public void setOutput(boolean output) {
    LinkJVMJNI.Digital_setOutput(swigCPtr, this, output);
  }

  public boolean isOutput() {
    return LinkJVMJNI.Digital_isOutput(swigCPtr, this);
  }

  public void setPullup(boolean pullup) {
    LinkJVMJNI.Digital_setPullup(swigCPtr, this, pullup);
  }

  public boolean pullup() {
    return LinkJVMJNI.Digital_pullup(swigCPtr, this);
  }

}
