/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package linkjvm.low;

public class Ir {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected Ir(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Ir obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        linkjvm_irJNI.delete_Ir(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public static void read() {
    linkjvm_irJNI.Ir_read();
  }

  public static void write() {
    linkjvm_irJNI.Ir_write();
  }

  public Ir() {
    this(linkjvm_irJNI.new_Ir(), true);
  }

}
