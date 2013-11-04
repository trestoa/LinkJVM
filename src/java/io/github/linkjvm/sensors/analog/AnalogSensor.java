package io.github.linkjvm.sensors.analog;

import io.github.linkjvm.jni.analog.Analog;
import io.github.linkjvm.jni.analog.Analog8;

/**
 * @author Markus Klein
 */
public class AnalogSensor implements AbstractAnalogSensor{
	private Analog8 jniSensor8;
	private Analog jniSensor;

	private int port;

	private void createJniSensors(){
		jniSensor = new Analog((short) port);
		jniSensor8 = new Analog8((short) port);
	}

	/**
	 *
	 * @param port
	 */
	public AnalogSensor(int port){
		this.port = port;
		createJniSensors();
	}

	/**
	 *
	 * @param port
	 */
	public AnalogSensor(short port){
		this.port = port;
		createJniSensors();
	}

	/**
	 *
	 * @param port
	 */
	public AnalogSensor(byte port){
		this.port = port;
		createJniSensors();
	}

	/**
	 *
	 * @return
	 */
	@Override
	public int getValue(){

	}

	/**
	 *
	 * @return
	 */
	@Override
	public int getValue8(){

	}
}
