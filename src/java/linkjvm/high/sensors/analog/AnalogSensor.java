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

package linkjvm.high.sensors.analog;

import linkjvm.high.sensors.InvalidPortException;
import linkjvm.low.analog.Analog;
import linkjvm.low.analog.Analog8;
import linkjvm.low.factory.JNIController;

/**
 * This class represents an analog sensor.
 * @author Markus Klein
 * @version 2.0.0
 * @since 2.0.0
 */
public class AnalogSensor implements IAnalogSensor{
	private volatile Analog8 jniSensor8;
	private volatile Analog jniSensor;

	private int port;

	/**
	 * Constructs a new analog sensor with at the specified port.
	 * @param port the analog sensor's port number
	 * @throws InvalidPortException
	 */
	public AnalogSensor(int port) throws InvalidPortException{
		if(port < 0 || port > 7){
			throw new InvalidPortException();
		}
		this.port = port;
		jniSensor = JNIController.getInstance().getAnalogFactory().getInstance(port);
		jniSensor8 = JNIController.getInstance().getAnalog8Factory().getInstance(port);
	}

	/**
	 * Returns the analog sensor's current value as 10 bit number.
	 * @return sensor's current value as 10 bit number
	 */
	@Override
	public int getValue(){
		return jniSensor.value();
	}
	
	/**
	 * The same as <code>getValue()</code>.
	 * @return sensor's current value as 10 bit number
	 */
	public int getValue10(){
		return getValue();
	}

	/**
	 * Returns the analog sensor's current value as 8 bit number.
	 * @return sensor's current value as 8 bit number
	 */
	public int getValue8(){
		return jniSensor8.value();
	}

	/**
	 * Sets the sensor's pullup.
	 * @param pullup pullup
	 */
	public void setPullup(boolean pullup){
		jniSensor.setPullup(pullup);
		jniSensor8.setPullup(pullup);
	}

	/**
	 * Returns the native 10bit sensor.
	 * @return native sensor
	 */
	Analog getJniSensor(){
		return jniSensor;
	}

	/**
	 * Returns the native 8bit sensor.
	 * @return native sensor
	 */
	Analog8 getJni8Sensor(){
		return jniSensor8;
	}

	/**
	 * Returns the sensor's port.
	 * @return port
	 */
	public int getPort(){
		return port;
	}
}
