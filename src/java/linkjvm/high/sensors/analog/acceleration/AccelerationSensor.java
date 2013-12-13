package linkjvm.high.sensors.analog.acceleration;

import linkjvm.high.sensors.analog.AbstractAnalogSensor;
import linkjvm.low.accel.AccelX;
import linkjvm.low.accel.AccelY;
import linkjvm.low.accel.AccelZ;
import linkjvm.low.accel.Acceleration;
import linkjvm.low.sensors.ShortSensor;

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
		setAxis(axis);
	}
	
	/**
	 * 
	 */
	public static void calibrate(){
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
	
	/**
	 * 
	 * @return
	 */
	public Axis getAxis(){
		return axis;
	}
	
	/**
	 * 
	 * @param axis
	 */
	public void setAxis(Axis axis){
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
}
