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
	
	public static void beep(){
		Libkovan.beep();
	}
	
	public void clearDisplay(){
		Libkovan.display_clear();
	}
	
	public void setDigitalOutput(int port, int inout){
		Libkovan.set_digital_output(port, inout);
	}
	
	public void setDigitalValue(int port, int val){
		Libkovan.set_digital_value(port, val);
	}
}
