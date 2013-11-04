package io.github.linkjvm.sensors.analog;

import io.github.linkjvm.jni.analog.Analog;
import io.github.linkjvm.jni.analog.Analog8;
import io.github.linkjvm.sensors.InvalidPortException;

/**
 * @author Markus Klein
 */
public class AnalogSensor implements AbstractAnalogSensor{
	private Analog8 jniSensor8;
	private Analog jniSensor;

	private int port;

	/**
	 *
	 * @param port
	 */
	public AnalogSensor(int port) throws InvalidPortException{
		if(port < 0 || port > 7){
			throw new InvalidPortException();
		}
		this.port = port;
		jniSensor = new Analog((short) port);
		jniSensor8 = new Analog8((short) port);
	}

	/**
	 *
	 * @return
	 */
	@Override
	public int getValue(){
		return jniSensor.value();
	}

	/**
	 *
	 * @return
	 */
	@Override
	public int getValue8(){
		return jniSensor8.value();
	}

	/**
	 *
	 * @param pullup
	 */
	public void setPullup(boolean pullup){
		jniSensor.setPullup(pullup);
		jniSensor8.setPullup(pullup);
	}

	public boolean getDigitalPullup(){
		return jniSensor.pullup();
	}

	/**
	 *
	 * @return
	 */
	public Analog getJniSensor(){
		return jniSensor;
	}

	/**
	 *
	 * @return
	 */
	public Analog8 getJni8Sensor(){
		return jniSensor8;
	}

	/**
	 *
	 * @return
	 */
	public int getPort(){
		return port;
	}
}
