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

package linkjvm.high.sensors.digital;

import linkjvm.high.sensors.InvalidPortException;
import linkjvm.low.Digital;

/**
 * @author Markus Klein
 */
public class DigitalSensor implements IDigitalSensor{
	private Digital jniSensor;

	private int port;

	/**
	 * 
	 * @param port
	 * @throws InvalidPortException
	 */
	public DigitalSensor(int port) throws InvalidPortException{
		if(port < 8 || port > 15){
			throw new InvalidPortException();
		}
		this.port = port;
		jniSensor = new Digital((short) port);
	}

	/**
	 * 
	 * @return
	 */
	public int getPort(){
		return port;
	}
	
	/**
	 * 
	 * @param port
	 */
	public void setPort(int port){
		jniSensor = new Digital((short) port);
		this.port = port;
	}
	

	/**
	 *
	 * @return
	 */
	@Override
	public boolean getValue(){
		return jniSensor.value();
	}
}
