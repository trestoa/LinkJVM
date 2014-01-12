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
import linkjvm.low.factory.JNIController;

/**
 * Represents a servo object with a given port.
 * @author Markus Klein
 * @since 2.0.0
 * @version 2.0.0
 */
public class Servo {

	private volatile linkjvm.low.Servo jniServo = null;
	
	/**
	 * Constructs a new servo using the giver port.
	 * @param port
	 * @throws InvalidPortException
	 */
	public Servo(int port) throws InvalidPortException{
		setPort(port);
	}
	
	/**
	 * Sets the servo«s port.
	 * @param port port
	 * @throws InvalidPortException
	 */
	public void setPort(int port) throws InvalidPortException{
		if(port > 4 || port < 0){
			throw new InvalidPortException();
		}
		jniServo = JNIController.getInstance().getServoFactory().getInstance(port);
	}
	
	/**
	 * Sets the servo«s position.
	 * @param pos position
	 */
	public void setPosition(int pos){
		jniServo.setPosition((long) pos);
	}
	
	/**
	 * Returns the current position.
	 * @return position
	 */
	public int getPosition(){
		return (int) jniServo.position();
	}
	
	/**
	 * Disables the servo.
	 */
	public void disable(){
		jniServo.disable();
	}
	
	/**
	 * Enables the servo.
	 */
	public void enable(){
		jniServo.enable();
	}
	
	/**
	 * Sets the servo enabled.
	 * @param enabled if the servo should be enabled
	 */
	public void setEnabled(boolean enabled){
		jniServo.setEnabled(enabled);
	}
	
	/**
	 * Returns if the servo is enabled.
	 * @return if the servo is enabled
	 */
	public boolean isEnabled(){
		return jniServo.isEnabled();
	}

	void setJniServo(linkjvm.low.Servo jniServo){
		this.jniServo = jniServo;
	}
	
	linkjvm.low.Servo getJniServo(){
		return jniServo;
	}
}
