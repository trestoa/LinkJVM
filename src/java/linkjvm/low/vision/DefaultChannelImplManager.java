/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package linkjvm.low.vision;

public class DefaultChannelImplManager extends ChannelImplManager {
  private long swigCPtr;

  protected DefaultChannelImplManager(long cPtr, boolean cMemoryOwn) {
    super(linkjvm_visionJNI.DefaultChannelImplManager_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(DefaultChannelImplManager obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        linkjvm_visionJNI.delete_DefaultChannelImplManager(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public DefaultChannelImplManager() {
    this(linkjvm_visionJNI.new_DefaultChannelImplManager(), true);
  }

  public void setImage(SWIGTYPE_p_cv__Mat image) {
    linkjvm_visionJNI.DefaultChannelImplManager_setImage(swigCPtr, this, SWIGTYPE_p_cv__Mat.getCPtr(image));
  }

  public ChannelImpl channelImpl(String name) {
    long cPtr = linkjvm_visionJNI.DefaultChannelImplManager_channelImpl(swigCPtr, this, name);
    return (cPtr == 0) ? null : new ChannelImpl(cPtr, false);
  }

}
