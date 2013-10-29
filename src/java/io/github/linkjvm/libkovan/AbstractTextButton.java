/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.linkjvm.libkovan;

public class AbstractTextButton extends AbstractButton {
  private long swigCPtr;

  protected AbstractTextButton(long cPtr, boolean cMemoryOwn) {
    super(LinkJVMJNI.AbstractTextButton_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(AbstractTextButton obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        LinkJVMJNI.delete_AbstractTextButton(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public void setText(String text) {
    LinkJVMJNI.AbstractTextButton_setText(swigCPtr, this, text);
  }

  public String text() {
    return LinkJVMJNI.AbstractTextButton_text(swigCPtr, this);
  }

  public boolean isTextDirty() {
    return LinkJVMJNI.AbstractTextButton_isTextDirty(swigCPtr, this);
  }

  public void resetText() {
    LinkJVMJNI.AbstractTextButton_resetText(swigCPtr, this);
  }

}
