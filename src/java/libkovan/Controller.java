/*
* This file is part of Libkovan Java.
*
* Java Framework for the KIPR Link
* Copyright (C) 2013 Markus Klein
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

import libkovan.jni.Libkovan;

/**
 * The Controller class provides all functions from the libkovan,
 * which does not really belong to a special robot component.
 * 
 * @author Markus Klein
 * @version 1.0.0
 */
public class Controller {
	
	/**
	 * This function wait for the light on the specified light port.
	 * 
	 * @param lightPort Analog port of the light sensor.
	 */
	public static void waitForLight(int lightPort){
		Libkovan.wait_for_light(lightPort);
	}
	
	/**
	 * Returns the power level of the system.
	 * 
	 * @return The power level of the KIPR Link
	 */
	public static double powerLevel(){
		return Libkovan.power_level();
	}
	
	/**
	 * Waits a specified time.
	 * 
	 * @param msecs time to wait int milliseconds
	 */
	public static void msleep(int msecs){
		Libkovan.msleep(msecs);
	}
	
	/**
	 * Returns the current system time in seconds
	 * 
	 * @return system time in seconds
	 */
	public static double seconds(){
		return System.currentTimeMillis() * 1000;
	}
	
	/**
	 * Causes a beep sound. Returns when the sound is finished.
	 */
	public static void beep(){
		Libkovan.beep();
	}
	
	/**
	 * Clears the console.
	 */
	public void clearDisplay(){
		Libkovan.display_clear();
	}
	
	/**
	 * The digital ports of the KIPR Link can be set to input or output.
	 * This method is used to toggle the mode.
	 * 
	 * @param port 
	 * @param inout
	 */
	public void setDigitalOutput(int port, int inout){
		Libkovan.set_digital_output(port, inout);
	}
	
	public void setDigitalValue(int port, int val){
		Libkovan.set_digital_value(port, val);
	}
}
