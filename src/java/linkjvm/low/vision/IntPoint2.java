/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package linkjvm.low.vision;

public class IntPoint2 {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected IntPoint2(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(IntPoint2 obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        linkjvm_visionJNI.delete_IntPoint2(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public IntPoint2(long x, long y) {
    this(linkjvm_visionJNI.new_IntPoint2(x, y), true);
  }

  public long x() {
    return linkjvm_visionJNI.IntPoint2_x(swigCPtr, this);
  }

  public long y() {
    return linkjvm_visionJNI.IntPoint2_y(swigCPtr, this);
  }

  public void setX(long x) {
    linkjvm_visionJNI.IntPoint2_setX(swigCPtr, this, x);
  }

  public void setY(long y) {
    linkjvm_visionJNI.IntPoint2_setY(swigCPtr, this, y);
  }

  public point2 toCPoint2() {
    return new point2(linkjvm_visionJNI.IntPoint2_toCPoint2(swigCPtr, this), true);
  }

}
