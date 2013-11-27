package io.github.linkjvm.sensors.analog.acceleration;

import io.github.linkjvm.jni.accel.AccelX;
import io.github.linkjvm.jni.accel.AccelY;
import io.github.linkjvm.jni.accel.AccelZ;
import io.github.linkjvm.jni.accel.Acceleration;
import io.github.linkjvm.jni.sensors.ShortSensor;
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
	
	private ShortSensor jniAccelSensor = null;
	private Axis axis;
	
	/**
	 * 
	 * @param axis
	 */
	public AccelerationSensor(Axis axis){
		if(axis == Axis.X){
			jniAccelSensor = new AccelX();
		}
		else if(axis == Axis.Y){
			jniAccelSensor = new AccelY();
		}
		else{
			jniAccelSensor = new AccelZ();
		}
		this.axis = axis;
	}
	
	/**
	 * 
	 */
	public void calibrate(){
		Acceleration.calibrate();
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public int getValue() {
		return jniAccelSensor.value();
	}
	
	/**
	 * 
	 * @return
	 */
	public ShortSensor getJniAcceleration(){
		return jniAccelSensor;
	}
	
	/**
	 * 
	 * @param jniAccel
	 */
	public void setJniAcceleration(ShortSensor jniAccelSensor){
		this.jniAccelSensor = jniAccelSensor;
	}
}
