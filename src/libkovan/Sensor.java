package libkovan;

import libkovan.jni.Libkovan;


public class Sensor {
	
	private int sensorPort;
	public static final int A_BUTTON = 0;
	public static final int B_BUTTON = 1;
	public static final int SIDE_BUTTON = 2;
	
	public Sensor(int sensorPort){
		this.sensorPort = sensorPort;
	}
	
	public int getPort(){
		return sensorPort;
	}
	
	public void setPort(int sensorPort){
		this.sensorPort = sensorPort;
	}
	
	public int getButtonPressed(int btn){
		switch(btn){
		case 0:
			return Libkovan.a_button();
		case 1:
			return Libkovan.b_button();
		case 2:
			return Libkovan.side_button();
		default:
			return 0;
		}
	}
	
	public int analog(){
		return Libkovan.analog(sensorPort);
	}
	
	public int analog10(){
		return Libkovan.analog10(sensorPort);
	}
	
	public int digital(){
		return Libkovan.digital(sensorPort);
	}
	
	public void setAnalogPullup(int pullup){
		Libkovan.set_analog_pullup(sensorPort, pullup);
	}
}
