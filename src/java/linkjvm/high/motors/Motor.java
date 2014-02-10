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
 * Represents a motor object with a given port.
 * @author Markus Klein
 * @version 2.1.0
 * @since 2.0.0
 */
public class Motor {
	
	private volatile linkjvm.low.motors.Motor jniMotor = null;
	
	/**
	 * Creates a new Motor object.
	 * @param port port of the Link, where the motor is connected to
	 * @throws InvalidPortException If the specified port is invalid
	 */
	public Motor(int port) throws InvalidPortException{
		setPort(port);
	}
	
	/**
	 * Resets the position counter of this motor object to 0 
	 */
	public void clearPositionCount(){
		jniMotor.clearPositionCounter();
	}
	
	/**
	 * Moves the motor at velocity with the specified ticks per seconds.
	 * @param velocity velocity in ticks per second (range from -1000 to 1000)
	 */
	public void moveAtVelocity(int velocity){
		jniMotor.moveAtVelocity((short) velocity);
	}
	
	/**
	 * Moves the motor to the specified position at the specified.
     * If motorPosition > specifiedPosition, the motor does not move.
	 * @param speed motor speed (range from 0 to 1000)
	 * @param targetPos motor position until the motor stops
	 */
	public void moveToPosition(int speed, int targetPos){
		jniMotor.moveToPosition((short) speed, targetPos);
	}
	
	/**
	 * Moves the motor from its current position to current position + pos.
	 * @param speed speed in ticks (range from -1000 to 1000)
	 * @param posDelta difference of the current and the final position
	 */
	public void moveToRelativePosition(int speed, int posDelta){
		jniMotor.moveRelativePosition((short) speed, posDelta);
	}
	
	/**
	 * Adjusts the weights of the PID control. If the motor is jerky, the p and d values should be reduced.
     * If a motor lags far behind they should be increased.
	 * @param p numerator for p coefficient
	 * @param i numerator for i coefficient
	 * @param d numerator for d coefficient
	 * @param pd p respective denominator
	 * @param id i respective denominator
	 * @param dd d respective denominator
	 */
	public void setPidGains(short p, short i, short d, short pd, short id, short dd){
		jniMotor.setPidGains(p, i, d, pd, id, dd);
	}
	
	/**
	 * Prevents the current motor movement.
	 */
	public void freeze(){
		jniMotor.freeze();
	}
	
	/**
	 * Returns if the motor is done with movement.
	 * @return <code>true</code> if motor is done with movement, <code>false</code> otherwise
	 */
	public boolean isMotorDone(){
		return jniMotor.isMotorDone();
	}
	
	/**
	 * Sets the current thread to idle until the motor is done with movement.
	 */
	public void blockMotorDone(){
		jniMotor.blockMotorDone();
	}
	
	/**
	 * Turns the motor speed to full forward.
	 */
	public void forward(){
		jniMotor.forward();
	}
	
	/**
	 * Turns the motor speed to full backward.
	 */
	public void backward(){
		jniMotor.backward();
	}
	
	/**
	 * Turn motor on the specified percentage.
	 * @param percent percentage with which the motor turns
	 * @deprecated
	 */
	public void turn(int percent){
		run(percent);
	}
	
	/**
	 * Turn motor on the specified percentage.
	 * @param percent motor's percentage
	 */
	public void run(int percent){
		jniMotor.motor(percent);
	}
	
	/**
	 * Turns the motor off.
	 */
	public void off(){
		jniMotor.off();
	}
	
	/**
	 * Returns the port of this motor object.
	 * @return port of the link, where the motor is connected to
	 */
	public int getPort(){
		return jniMotor.port();
	}
	
	/**
	 * Sets the port of this motor object.
	 * @param port port of the Link, where the motor is connected to
	 * @throws InvalidPortException If the specified port is invalid
	 */
	public void setPort(int port) throws InvalidPortException{
		if(port > 4 || port < 0){
			throw new InvalidPortException();
		}
		jniMotor = JNIController.getInstance().getMotorFactory().getInstance(port);
	}
	
	/**
	 * Sets the native motor object.
	 * DO NOT USE THIS METHOD UNLESS TO KNOW WHAT YOU ARE DOING!
	 * @see linkjvm.low.motors.Motor
	 * @param jniMotor the native motor object
	 */
	void setJniMotor(linkjvm.low.motors.Motor jniMotor){
		this.jniMotor = jniMotor;
	}
	
	linkjvm.low.motors.Motor getJniMotor(){
		return jniMotor;
	}
}
