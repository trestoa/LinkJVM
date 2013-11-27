package io.github.linkjvm.sensors.analog.acceleration;

import io.github.linkjvm.jni.accel.Acceleration;
import io.github.linkjvm.sensors.analog.AbstractAnalogSensor;

/**
 * 
 * @author Markus Klein
 *
 */
public class AccelerationSensor implements AbstractAnalogSensor{
	
	/**
	 * 
	 * @author Markus Klein
	 *
	 */
	public static enum Axis{
		Y,
		X,
		Z
	}

	private Acceleration jniAccel = null;
	private Axis axis;
	
	/**
	 * 
	 * @param axis
	 */
	public AccelerationSensor(Axis axis){
		jniAccel = new Acceleration();
		this.axis = axis;
	}
	
	/**
	 * 
	 */
	public void calibrate(){
		jniAccel.calibrate();
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public int getValue() {
		if(axis == Axis.X){
			return jniAccel.x();
		}
		else if(axis == Axis.Y){
			return jniAccel.y();
		}
		else{
			return jniAccel.z();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public Acceleration getJniAcceleration(){
		return jniAccel;
	}
	
	/**
	 * 
	 * @param jniAccel
	 */
	public void setJniAcceleration(Acceleration jniAccel){
		this.jniAccel = jniAccel;
	}
}
