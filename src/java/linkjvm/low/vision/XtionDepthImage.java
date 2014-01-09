/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package linkjvm.low.vision;

public class XtionDepthImage extends DepthImage {
  private long swigCPtr;

  protected XtionDepthImage(long cPtr, boolean cMemoryOwn) {
    super(linkjvm_visionJNI.XtionDepthImage_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(XtionDepthImage obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        linkjvm_visionJNI.delete_XtionDepthImage(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public XtionDepthImage(SWIGTYPE_p_void data, long size, long width, long height, int orientation, SWIGTYPE_p_depth__XtionDepthDriverImpl impl) {
    this(linkjvm_visionJNI.new_XtionDepthImage(SWIGTYPE_p_void.getCPtr(data), size, width, height, orientation, SWIGTYPE_p_depth__XtionDepthDriverImpl.getCPtr(impl)), true);
  }

  public void setOrientation(int orientation) {
    linkjvm_visionJNI.XtionDepthImage_setOrientation(swigCPtr, this, orientation);
  }

  public int orientation() {
    return linkjvm_visionJNI.XtionDepthImage_orientation(swigCPtr, this);
  }

  public long height() {
    return linkjvm_visionJNI.XtionDepthImage_height(swigCPtr, this);
  }

  public long width() {
    return linkjvm_visionJNI.XtionDepthImage_width(swigCPtr, this);
  }

  public int depthAt(long row, long column) {
    return linkjvm_visionJNI.XtionDepthImage_depthAt(swigCPtr, this, row, column);
  }

  public void depth(int[] data, long offset, long size) {
    linkjvm_visionJNI.XtionDepthImage_depth(swigCPtr, this, data, offset, size);
  }

  public IntPoint3 pointAt(long row, long column) {
    return new IntPoint3(linkjvm_visionJNI.XtionDepthImage_pointAt(swigCPtr, this, row, column), true);
  }

}
