package libkovan;

import libkovan.jni.Libkovan;

public class Servo {
	
	private int servoPort;
	
	public Servo(int servoPort){
		this.servoPort = servoPort;
	}
	
	public void setPort(int port){
		servoPort = port;
	}
	
	public int getPort(){
		return servoPort;
	}
	
	public void disable(){
		Libkovan.disable_servo(servoPort);
	}
	
	public void enable(){
		Libkovan.enable_servo(servoPort);
	}
	
	public void setPosition(int pos){
		Libkovan.set_servo_position(servoPort, pos);
	}
	
	public int getPosition(){
		return Libkovan.get_servo_position(servoPort);
	}
	
	public static void enableServos(){
		Libkovan.enable_servos();
	}
	
	public static void disableServos(){
		Libkovan.disable_servos();
	}
}
