/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.linkjvm.libkovan;

public class _4 {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected _4(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(_4 obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        LinkJVMJNI.delete__4(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setWallSignal(SWIGTYPE_p_unsigned_char value) {
    LinkJVMJNI._4_wallSignal_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_char getWallSignal() {
    long cPtr = LinkJVMJNI._4_wallSignal_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public void setCliffLeftSignal(SWIGTYPE_p_unsigned_char value) {
    LinkJVMJNI._4_cliffLeftSignal_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_char getCliffLeftSignal() {
    long cPtr = LinkJVMJNI._4_cliffLeftSignal_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public void setCliffFrontLeftSignal(SWIGTYPE_p_unsigned_char value) {
    LinkJVMJNI._4_cliffFrontLeftSignal_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_char getCliffFrontLeftSignal() {
    long cPtr = LinkJVMJNI._4_cliffFrontLeftSignal_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public void setCliffFrontRightSignal(SWIGTYPE_p_unsigned_char value) {
    LinkJVMJNI._4_cliffFrontRightSignal_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_char getCliffFrontRightSignal() {
    long cPtr = LinkJVMJNI._4_cliffFrontRightSignal_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public void setCliffRightSignal(SWIGTYPE_p_unsigned_char value) {
    LinkJVMJNI._4_cliffRightSignal_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_char getCliffRightSignal() {
    long cPtr = LinkJVMJNI._4_cliffRightSignal_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public void setUserDigitalInputs(short value) {
    LinkJVMJNI._4_userDigitalInputs_set(swigCPtr, this, value);
  }

  public short getUserDigitalInputs() {
    return LinkJVMJNI._4_userDigitalInputs_get(swigCPtr, this);
  }

  public void setUserAnalogInput(SWIGTYPE_p_unsigned_char value) {
    LinkJVMJNI._4_userAnalogInput_set(swigCPtr, this, SWIGTYPE_p_unsigned_char.getCPtr(value));
  }

  public SWIGTYPE_p_unsigned_char getUserAnalogInput() {
    long cPtr = LinkJVMJNI._4_userAnalogInput_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_unsigned_char(cPtr, false);
  }

  public void setChargingSourcesAvailable(short value) {
    LinkJVMJNI._4_chargingSourcesAvailable_set(swigCPtr, this, value);
  }

  public short getChargingSourcesAvailable() {
    return LinkJVMJNI._4_chargingSourcesAvailable_get(swigCPtr, this);
  }

  public _4() {
    this(LinkJVMJNI.new__4(), true);
  }

}
