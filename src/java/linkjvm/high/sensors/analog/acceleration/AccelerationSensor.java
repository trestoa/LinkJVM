/*
 * This file is part of LinkJVM.
 *
 * Java Framework for the KIPR Link
 * Copyright (C) 2013 Markus Klein<m@mklein.co.at>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package linkjvm.high.sensors.analog.acceleration;

import linkjvm.high.sensors.analog.IAnalogSensor;
import linkjvm.low.accel.Acceleration;
import linkjvm.low.sensors.ShortSensor;
import linkjvm.low.factory.JNIController;
import linkjvm.low.factory.AccelerationFactory;

/**
 * An object of this class is used to access the KIPR Link's acceleration sensors.
 * @author Markus Klein
 * @version 2.0.0
 * @since 2.0.0
 */
public class AccelerationSensor implements IAnalogSensor{
	
	/**
	 * The Axis enum contains all possible axis for an acceleration sensors.
	 * @author Markus Klein
	 *
	 */
	public static enum Axis{
		Y,
		X,
		Z
	}
	
	private volatile ShortSensor jniAccelSensor = null;
	private Axis axis;
	
	/**
	 * Constructs a new acceleration sensor with the giver axis.
	 * @param axis
	 */
	public AccelerationSensor(Axis axis){
		setAxis(axis);
	}
	
	/**
	 * Calibrates the acceleration sensors.
	 */
	public static void calibrate(){
		Acceleration.calibrate();
	}
	
	/**
	 * Returns the current sensor value.
	 * @return sensor value
	 */
	@Override
	public int getValue() {
		return jniAccelSensor.value();
	}
	
	ShortSensor getJniAcceleration(){
		return jniAccelSensor;
	}
	
	void setJniAcceleration(ShortSensor jniAccelSensor){
		this.jniAccelSensor = jniAccelSensor;
	}
	
	/**
	 * Returns the sensor's axis.
	 * @return axis
	 */
	public Axis getAxis(){
		return axis;
	}
	
	/**
	 * Sets the sensor's axis.
	 * @param axis 
	 */
	public void setAxis(Axis axis){
		if(axis == Axis.X){
			jniAccelSensor = JNIController.getInstance().getAccelerationFactory().getInstance(AccelerationFactory.Axis.X);
		}
		else if(axis == Axis.Y){
			jniAccelSensor = JNIController.getInstance().getAccelerationFactory().getInstance(AccelerationFactory.Axis.Y);
		}
		else{
			jniAccelSensor = JNIController.getInstance().getAccelerationFactory().getInstance(AccelerationFactory.Axis.Z);
		}
		this.axis = axis;
	}
}
