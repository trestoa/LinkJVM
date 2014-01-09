/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package linkjvm.low.vision;

public class DepthImage {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected DepthImage(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(DepthImage obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        linkjvm_visionJNI.delete_DepthImage(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setOrientation(int orientation) {
    linkjvm_visionJNI.DepthImage_setOrientation(swigCPtr, this, orientation);
  }

  public int orientation() {
    return linkjvm_visionJNI.DepthImage_orientation(swigCPtr, this);
  }

  public long height() {
    return linkjvm_visionJNI.DepthImage_height(swigCPtr, this);
  }

  public long width() {
    return linkjvm_visionJNI.DepthImage_width(swigCPtr, this);
  }

  public int depthAt(long row, long column) {
    return linkjvm_visionJNI.DepthImage_depthAt(swigCPtr, this, row, column);
  }

  public void depth(int[] data, long offset, long size) {
    linkjvm_visionJNI.DepthImage_depth(swigCPtr, this, data, offset, size);
  }

  public IntPoint3 pointAt(long row, long column) {
    return new IntPoint3(linkjvm_visionJNI.DepthImage_pointAt(swigCPtr, this, row, column), true);
  }

}
