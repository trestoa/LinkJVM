/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package linkjvm.low.vision;

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
        linkjvm_visionJNI.delete_rectangle(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setUlx(int value) {
    linkjvm_visionJNI.rectangle_ulx_set(swigCPtr, this, value);
  }

  public int getUlx() {
    return linkjvm_visionJNI.rectangle_ulx_get(swigCPtr, this);
  }

  public void setUly(int value) {
    linkjvm_visionJNI.rectangle_uly_set(swigCPtr, this, value);
  }

  public int getUly() {
    return linkjvm_visionJNI.rectangle_uly_get(swigCPtr, this);
  }

  public void setWidth(int value) {
    linkjvm_visionJNI.rectangle_width_set(swigCPtr, this, value);
  }

  public int getWidth() {
    return linkjvm_visionJNI.rectangle_width_get(swigCPtr, this);
  }

  public void setHeight(int value) {
    linkjvm_visionJNI.rectangle_height_set(swigCPtr, this, value);
  }

  public int getHeight() {
    return linkjvm_visionJNI.rectangle_height_get(swigCPtr, this);
  }

  public rectangle() {
    this(linkjvm_visionJNI.new_rectangle(), true);
  }

}
