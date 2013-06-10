/*
* This file is part of LinkJVM Java.
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

package libkovan;

import libkovan.jni.LinkJVM;

/**
 * An instance of this class is used to control one digital sensor on the specified sensor port.
 * 
 * @author Markus Klein
 * @version 1.0.0
 */

public class DigitalSensor extends Sensor{
	
	/**
	 * Creates a new digital sensor on the specified port.
	 * The invocation {@code DigitalSensor sensor = new DigitalSensor(0)} is equivalent to:
	 * {@code DigitalSensor sensor = new DigitalSensor();
	 * sensor.setPort(0);}
	 * 
	 * @param sensorPort the port of the analog sensor
	 */
	public DigitalSensor(int sensorPort) {
		super(sensorPort);
	}
	
	/**
	 * Returns the sensor value.
	 * 
	 * @return sensor value
	 */
	public int getValue() {
		return LinkJVM.digital(sensorPort);
	}
	

}
