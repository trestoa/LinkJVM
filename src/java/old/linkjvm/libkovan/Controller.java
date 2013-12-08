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

package old.linkjvm.libkovan;

import old.linkjvm.events.Event;
import old.linkjvm.events.EventManager;
import old.linkjvm.libkovan.jni.LinkJVM;

/**
 * The Controller class provides all functions from the libkovan,
 * which does not really belong to a special robot component.
 * 
 * @author Markus Klein
 * @version 1.0.0
 */
public class Controller {

	static EventManager eventManager = new EventManager();
	
	/**
	 * This function wait for the light on the specified light port.
	 * 
	 * @param lightPort Analog port of the light sensor.
	 */
	public void waitForLight(int lightPort){
		LinkJVM.wait_for_light(lightPort);
	}
	
	/**
	 * Returns the power level of the system.
	 * 
	 * @return The power level of the KIPR Link
	 */
	public double powerLevel(){
		return LinkJVM.power_level();
	}
	
	/**
	 * Waits a specified time.
	 * 
	 * @param msecs time to wait int milliseconds
	 */
	public void msleep(int msecs){
		LinkJVM.msleep(msecs);
	}
	
	/**
	 * Returns the current system time in seconds
	 * 
	 * @return system time in seconds
	 */
	public double seconds(){
		return System.currentTimeMillis() * 1000;
	}
	
	/**
	 * Causes a beep sound. Returns when the sound is finished.
	 */
	public void beep(){
		LinkJVM.beep();
	}
	
	/**
	 * Clears the console.
	 */
	public void clearDisplay(){
		LinkJVM.display_clear();
	}
	
	/**
	 * The digital ports of the KIPR Link can be set to input or output.
	 * This method is used to toggle the mode.
	 * 
	 * @param port 
	 * @param inout
	 */
	public void setDigitalOutput(int port, int inout){
		LinkJVM.set_digital_output(port, inout);
	}
	
	public void setDigitalValue(int port, int val){
		LinkJVM.set_digital_value(port, val);
	}
	
	/**
	 * Activates triggering the events
	 */
	public void startEvents(){
		eventManager.start();
	}
	
	/**
	 * Deativates triggering the events. Always call this method if at the end of your program if you called <code>startEvents();</code> before.
	 */
	public void stopEvents(){
		eventManager.stop();
	}
	
	/**
	 * Registers a new event.
	 * 
	 * @param e Event which should be registered
	 */ 
	public void registerEvent(Event e){
		eventManager.registerEvent(e);
	}
	
	/**
	 * Unregisters the first occurence of the specified event
	 * 
	 * @param e Event
	 */ 
	public void unregisterEvent(Event e){
		eventManager.unregisterEvent(e);
	}
}
