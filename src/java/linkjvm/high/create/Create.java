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

package linkjvm.high.create;

import linkjvm.low.factory.JNIController;

/**
 * 
 * @author Markus Klein
 * @version 2.0.3
 * @since 2.0.0
 * An instance of this class is used to control the iRobot create.
 */
public class Create {
	
	/**
	 * 
	 * @author Markus Klein
	 * This enum represents the create's mode.
	 * The different modes are:
	 * <ul>
	 * 	<li>Safe: The create will execute all command until the drop or cliff fire. Then it will stop.</li>
	 * 	<li>Full: Create will to everything and never stop even if cliff or drop fire.</li>
	 * 	<li>Passive: Sets the create into the passive mode(no motors).</li>
	 * </ul>
	 * @version 2.0.0
	 * @since 2.0.0
	 */
	public static enum Mode{
		SAFE,
		PASSIVE,
		FULL;
	}
	
	private volatile linkjvm.low.create.Create jniCreate = null;

	/**
	 * Create a new create object.
	 */
	public Create(){
		jniCreate = JNIController.getInstance().getCreateFactory().getInstance();
	}
	
	/**
	 * Builds up a connection to the Create.
	 * 
	 * @return <code>true</code> if everything worked fine, <code>false</code> if an error occurred
	 */
	public boolean connect(){
		return jniCreate.connect();
	}
	
	/**
	 * Closes the connection to the Create.
	 * 
	 * @return <code>true</code> if everything worked fine, <code>false</code> if an error occurred
	 */
	public boolean disconnect(){
		return jniCreate.disconnect();
	}
	
	/**
	 * Returns <code>true</code>, when connected to the Create, <code>false</code> otherwise.
	 * 
	 * @return <code>true</code>, when connected to the Create, <code>false</code> otherwise
	 */
	public boolean isConnected(){
		return jniCreate.isConnected();
	}
	
	/**
	 * Sets the creates mode.
	 * @see Create.Mode
	 * @param mode 
	 */
	public void setMode(Mode mode){	
		if(mode == Mode.SAFE){
			jniCreate.setSafeMode();
		}
		else if(mode == Mode.FULL){
			jniCreate.setFullMode();
		}
		else if(mode == Mode.PASSIVE){
			jniCreate.setPassiveMode();
		}
	}
	
	/**
	 * Sets the create LEDs.
	 * @param advance if the advanced led should be on
	 * @param play if the play led should be on
	 * @param color the LEDs color
	 * @param brightness the LEDs brightness
	 */
	public void setLeds(boolean advance, boolean play, int color, short brightness){
		jniCreate.setLeds(advance, play, (short) color, (short) brightness);
	}
	
	/**
	 * Drives an arc.
	 * 
	 * @param velocity speed from 20 to 500 mm/sec
	 * @param radius radius
	 */
	public void drive(int velocity, int radius){
		jniCreate.drive((short) velocity, (short) radius);
	}
	
	/**
	 * Sets the speed of every motor in mm per sec from -500 (full backward) to 500 (full forward).
	 * 
	 * @param left left motors speed
	 * @param right right motors speed
	 */
	public void driveDirect(int left, int right){
		jniCreate.driveDirect((short) left, (short) right);
	}
	
	/**
	 * Causes the create to drive streight at a specific speed.
	 * @param speed velocity form -500 (full backward) to 500 (full forward)
	 */
	public void driveStraigth(int speed){
		jniCreate.driveStraight((short) speed);
	}
	
	/**
	 * Causes the create to stop.
	 */
	public void stop(){
		jniCreate.stop();
	}
	
	/**
	 * Turns the create.
	 * 
	 * @param angle angle
	 * @param speed speed
	 */
	public void turn(int angle, int speed){
		jniCreate.turn((short) angle, speed);
	}
	
	/**
	 * Moves the to a specific position.
	 * 
	 * @param millimeters the distance which should be covered
	 * @param speed speed
	 */
	public void move(int millimeters, int speed){
		jniCreate.move((short) millimeters, speed);
	}
	
	/**
	 * Lets the create spin at its current position.
	 * @param speed spped
	 */
	public void spin(int speed){
		jniCreate.spin((short) speed);
	}
	
	/**
	 * Return the angular velocity.
	 * @return angular velocity
	 */
	public int angularVelocity(){
		return (int) jniCreate.angularVelocity();
	}
	
	/**
	 * Causes to create to spin clockwise.
	 * @param speed speed
	 */
	public void spinClockwise(int speed){
		jniCreate.spinClockwise((short) speed);
	}
	
	/**
	 * Causes the create to spin counterclockwise.
	 * @param speed speed
	 */
	public void spinCounterClockwise(int speed){
		jniCreate.spinCounterClockwise((short) speed);
	}
	
	/**
	 * Sets the creates distance.
	 * 
	 * @param distance distance
	 */
	public void setDistance(int distance){
		jniCreate.setDistance(distance);
	}
	
	/**
	 * Sets the creates angle.
	 * 
	 * @param angle angle
	 */
	public void setAngle(int angle){
		jniCreate.setAngle(angle);
	}
	
	/**
	 * Returns the right bumper value.
	 * @return <code>true</code> if the bumper is pressed, <code>false</code> otherwise
	 */
	public boolean getRightBump(){
		return jniCreate.bumpRight().value();
	}
	
	/**
	 * Returns the left bumper value.
	 * @return <code>true</code> if the bumper is pressed, <code>false</code> otherwise
	 */
	public boolean getLeftBump(){
		return jniCreate.bumpLeft().value();
	}
	
	/**
	 * Returns the left cliff value
	 * @return left cliff value
	 */
	public int getLeftCliff(){
		return jniCreate.cliffLeftSignal().value();
	}
	
	/**
	 * Returns the right cliff value
	 * @return right cliff value
	 */
	public int getRightCliff(){
		return jniCreate.cliffRightSignal().value();
	}
	
	/**
	 * Returns the left front cliff value
	 * @return left front cliff value
	 */
	public int getLeftFrontCliff(){
		return jniCreate.cliffFrontLeftSignal().value();
	}
	
	/**
	 * Returns the right front cliff value
	 * @return right front cliff value
	 */
	public int getRightFrontCliff(){
		return jniCreate.cliffFrontRightSignal().value();
	}
}
