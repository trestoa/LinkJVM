/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package linkjvm.low.analog;

public class linkjvm_analogJNI {
  public final static native long new_Analog(short jarg1);
  public final static native int Analog_value(long jarg1, Analog jarg1_);
  public final static native void Analog_setPullup(long jarg1, Analog jarg1_, boolean jarg2);
  public final static native boolean Analog_pullup(long jarg1, Analog jarg1_);
  public final static native short Analog_port(long jarg1, Analog jarg1_);
  public final static native void delete_Analog(long jarg1);
  public final static native long new_Analog8(short jarg1);
  public final static native int Analog8_value(long jarg1, Analog8 jarg1_);
  public final static native void delete_Analog8(long jarg1);
  public final static native long Analog_SWIGUpcast(long jarg1);
  public final static native long Analog8_SWIGUpcast(long jarg1);
}
