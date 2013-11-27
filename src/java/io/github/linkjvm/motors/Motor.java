package io.github.linkjvm.motors;

import io.github.linkjvm.sensors.InvalidPortException;

/**
 * 
 * @author Markus Klein
 *
 */
public class Motor {
	
	private io.github.linkjvm.jni.motors.Motor jniMotor = null;
	
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
		jniMotor = new io.github.linkjvm.jni.motors.Motor((short) port);
	}
	
	public void setJniMotor(io.github.linkjvm.jni.motors.Motor jniMotor){
		this.jniMotor = jniMotor;
	}
	
	public io.github.linkjvm.jni.motors.Motor getJniMotor(){
		return jniMotor;
	}
}
