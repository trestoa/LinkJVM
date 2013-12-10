package linkjvm.high.sensors.buttons;

import linkjvm.high.sensors.digital.AbstractDigitalSensor;
import linkjvm.low.buttons.IdButton;

public abstract class AbstractButton implements AbstractDigitalSensor{
	private IdButton jniButton;
	
	/**
	 * 
	 * @return
	 */
	public abstract boolean isPressed();
	
	/**
	 * 
	 * @return
	 */
	@Override
	public boolean getValue() {
		// TODO Auto-generated method stub
		return false;
	}

}
