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
