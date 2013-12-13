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

package linkjvm.high.motors;

import linkjvm.high.sensors.InvalidPortException;

public class Servo {

	private linkjvm.low.Servo jniServo = null;
	
	/**
	 * 
	 * @param port
	 * @throws InvalidPortException
	 */
	public Servo(int port) throws InvalidPortException{
		setPort(port);
	}
	
	/**
	 * 
	 * @param port
	 * @throws InvalidPortException
	 */
	public void setPort(int port) throws InvalidPortException{
		if(port > 4 || port < 0){
			throw new InvalidPortException();
		}
		jniServo = new linkjvm.low.Servo(port);
	}
	
	/**
	 * 
	 * @param pos
	 */
	public void setPosition(int pos){
		jniServo.setPosition((long) pos);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPosition(){
		return (int) jniServo.position();
	}
	
	/**
	 * 
	 */
	public void disable(){
		jniServo.disable();
	}
	
	/**
	 * 
	 */
	public void enable(){
		jniServo.enable();
	}
	
	/**
	 * 
	 * @param enabled
	 */
	public void setEnabled(boolean enabled){
		jniServo.setEnabled(enabled);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEnabled(){
		return jniServo.isEnabled();
	}
	
	/**
	 * 
	 * @param jniServo
	 */
	public void setJniServo(linkjvm.low.Servo jniServo){
		this.jniServo = jniServo;
	}
	
	/**
	 * 
	 * @return
	 */
	public linkjvm.low.Servo getJniServo(){
		return jniServo;
	}
}
