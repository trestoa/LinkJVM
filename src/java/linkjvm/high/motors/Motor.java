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
 * 
 * @author Markus Klein
 *
 */
public class Motor {
	
	private linkjvm.low.motors.Motor jniMotor = null;
	
	/**
	 * 
	 * @param port
	 * @throws InvalidPortException
	 */
	public Motor(int port) throws InvalidPortException{
		setPort(port);
	}
	
	/**
	 * 
	 */
	public void clearPositionCount(){
		jniMotor.clearPositionCounter();
	}
	
	/**
	 * 
	 * @param velocity
	 */
	public void moveAtVelocity(int velocity){
		jniMotor.moveAtVelocity((short) velocity);
	}
	
	/**
	 * 
	 * @param speed
	 * @param targetPos
	 */
	public void moveToPosition(int speed, int targetPos){
		jniMotor.moveToPosition((short) speed, targetPos);
	}
	
	/**
	 * 
	 * @param speed
	 * @param posDelta
	 */
	public void moveToRelativePosition(int speed, int posDelta){
		jniMotor.moveRelativePosition((short) speed, posDelta);
	}
	
	/**
	 * 
	 * @param p
	 * @param i
	 * @param d
	 * @param pd
	 * @param id
	 * @param dd
	 */
	public void setPidGains(short p, short i, short d, short pd, short id, short dd){
		jniMotor.setPidGains(p, i, d, pd, id, dd);
	}
	
	/**
	 * 
	 */
	public void freeze(){
		jniMotor.freeze();
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isMotorDone(){
		return jniMotor.isMotorDone();
	}
	
	/**
	 * 
	 */
	public void blockMotorDone(){
		jniMotor.blockMotorDone();
	}
	
	/**
	 * 
	 */
	public void forward(){
		jniMotor.forward();
	}
	
	/**
	 * 
	 */
	public void backward(){
		jniMotor.backward();
	}
	
	/**
	 * 
	 * @param percent
	 */
	public void turn(int percent){
		jniMotor.motor(percent);
	}
	
	/**
	 * 
	 */
	public void off(){
		jniMotor.off();
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPort(){
		return jniMotor.port();
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
		jniMotor = JNIController.getInstance().getMotorFactory().getInstance(port);
	}
	
	public void setJniMotor(linkjvm.low.motors.Motor jniMotor){
		this.jniMotor = jniMotor;
	}
	
	public linkjvm.low.motors.Motor getJniMotor(){
		return jniMotor;
	}
}
