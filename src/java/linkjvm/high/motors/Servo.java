package linkjvm.high.motors;

import linkjvm.high.sensors.InvalidPortException;

public class Servo {

	private linkjvm.low.Servo jniServo = null;
	
	/**
	 * 
	 * @param port
	 * @throws InvalidPortException
	 */
	public Servo(int port) throws InvalidPortException{
		setPort(port);
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
		jniServo = new linkjvm.low.Servo(port);
	}
	
	/**
	 * 
	 * @param pos
	 */
	public void setPosition(int pos){
		jniServo.setPosition((long) pos);
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPosition(){
		return (int) jniServo.position();
	}
	
	/**
	 * 
	 */
	public void disable(){
		jniServo.disable();
	}
	
	/**
	 * 
	 */
	public void enable(){
		jniServo.enable();
	}
	
	/**
	 * 
	 * @param enabled
	 */
	public void setEnabled(boolean enabled){
		jniServo.setEnabled(enabled);
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEnabled(){
		return jniServo.isEnabled();
	}
	
	/**
	 * 
	 * @param jniServo
	 */
	public void setJniServo(linkjvm.low.Servo jniServo){
		this.jniServo = jniServo;
	}
	
	/**
	 * 
	 * @return
	 */
	public linkjvm.low.Servo getJniServo(){
		return jniServo;
	}
}
