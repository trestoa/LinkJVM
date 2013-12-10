/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package linkjvm.low.camera;

public class UsbInputProvider extends InputProvider {
  private long swigCPtr;

  protected UsbInputProvider(long cPtr, boolean cMemoryOwn) {
    super(linkjvm_cameraJNI.UsbInputProvider_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(UsbInputProvider obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        linkjvm_cameraJNI.delete_UsbInputProvider(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public UsbInputProvider() {
    this(linkjvm_cameraJNI.new_UsbInputProvider(), true);
  }

  public boolean open(int number) {
    return linkjvm_cameraJNI.UsbInputProvider_open(swigCPtr, this, number);
  }

  public boolean isOpen() {
    return linkjvm_cameraJNI.UsbInputProvider_isOpen(swigCPtr, this);
  }

  public void setWidth(long width) {
    linkjvm_cameraJNI.UsbInputProvider_setWidth(swigCPtr, this, width);
  }

  public void setHeight(long height) {
    linkjvm_cameraJNI.UsbInputProvider_setHeight(swigCPtr, this, height);
  }

  public boolean next(SWIGTYPE_p_cv__Mat image) {
    return linkjvm_cameraJNI.UsbInputProvider_next(swigCPtr, this, SWIGTYPE_p_cv__Mat.getCPtr(image));
  }

  public boolean close() {
    return linkjvm_cameraJNI.UsbInputProvider_close(swigCPtr, this);
  }

}