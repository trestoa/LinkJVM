/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.9
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package io.github.linkjvm.jni.motors;

public class linkjvm_motorJNI {
  public final static native long new_Motor(int jarg1);
  public final static native void Motor_clearPositionCounter(long jarg1, Motor jarg1_);
  public final static native void Motor_moveAtVelocity(long jarg1, Motor jarg1_, short jarg2);
  public final static native void Motor_moveToPosition(long jarg1, Motor jarg1_, short jarg2, int jarg3);
  public final static native void Motor_moveRelativePosition(long jarg1, Motor jarg1_, short jarg2, int jarg3);
  public final static native void Motor_setPidGains(long jarg1, Motor jarg1_, short jarg2, short jarg3, short jarg4, short jarg5, short jarg6, short jarg7);
  public final static native void Motor_pidGains(long jarg1, Motor jarg1_, long jarg2, long jarg3, long jarg4, long jarg5, long jarg6, long jarg7);
  public final static native void Motor_freeze(long jarg1, Motor jarg1_);
  public final static native boolean Motor_isMotorDone(long jarg1, Motor jarg1_);
  public final static native void Motor_blockMotorDone(long jarg1, Motor jarg1_);
  public final static native void Motor_forward(long jarg1, Motor jarg1_);
  public final static native void Motor_backward(long jarg1, Motor jarg1_);
  public final static native void Motor_motor(long jarg1, Motor jarg1_, int jarg2);
  public final static native void Motor_off(long jarg1, Motor jarg1_);
  public final static native int Motor_port(long jarg1, Motor jarg1_);
  public final static native void delete_Motor(long jarg1);
  public final static native long new_BackEMF(short jarg1);
  public final static native int BackEMF_value(long jarg1, BackEMF jarg1_);
  public final static native short BackEMF_port(long jarg1, BackEMF jarg1_);
  public final static native void delete_BackEMF(long jarg1);
  public final static native long BackEMF_SWIGUpcast(long jarg1);
}
