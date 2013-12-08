package linkjvm.create;

public class Create {
	private static Create createInstance = new Create();
	
	/**
	 * 
	 * @author Markus Klein
	 *
	 */
	public static enum Mode{
		Safe,
		Passive,
		Full,
		Off
	}
	
	private linkjvm.jni.create.Create jniCreate = null;
	
	/**
	 * 
	 * @return
	 */
	public static Create getInstance(){
		return createInstance;
	}

	/**
	 * 
	 */
	private Create(){
		jniCreate = linkjvm.jni.create.Create.instance();
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean connect(){
		return jniCreate.connect();
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean disconnect(){
		return jniCreate.disconnect();
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isConnected(){
		return jniCreate.isConnected();
	}
	
	/**
	 * 
	 * @param mode
	 */
	public void setMode(Mode mode){	
		if(mode == Mode.Safe){
			jniCreate.setSafeMode();
		}
		else if(mode == Mode.Full){
			jniCreate.setFullMode();
		}
		else if(mode == Mode.Passive){
			jniCreate.setPassiveMode();
		}
	}
	
	/**
	 * 
	 * @param advance
	 * @param play
	 * @param color
	 * @param brightness
	 */
	public void setLeds(boolean advance, boolean play, int color, short brightness){
		jniCreate.setLeds(advance, play, (short) color, (short) brightness);
	}
	
	/**
	 * 
	 * @param velocity
	 * @param radius
	 */
	public void drive(int velocity, int radius){
		jniCreate.drive((short) velocity, (short) radius);
	}
	
	/**
	 * 
	 * @param left
	 * @param right
	 */
	public void driveDirect(int left, int right){
		jniCreate.driveDirect((short) left, (short) right);
	}
	
	/**
	 * 
	 * @param speed
	 */
	public void driveStraigth(int speed){
		jniCreate.driveStraight((short) speed);
	}
	
	/**
	 * 
	 */
	public void stop(){
		jniCreate.stop();
	}
	
	/**
	 * 
	 * @param angle
	 * @param speed
	 */
	public void turn(int angle, int speed){
		jniCreate.turn((short) angle, speed);
	}
	
	/**
	 * 
	 * @param millimeters
	 * @param speed
	 */
	public void move(int millimeters, int speed){
		jniCreate.move((short) millimeters, speed);
	}
	
	/**
	 * 
	 * @param speed
	 */
	public void spin(int speed){
		jniCreate.spin((short) speed);
	}
	
	/**
	 * 
	 * @return
	 */
	public int angularVelocity(){
		return (int) jniCreate.angularVelocity();
	}
	
	/**
	 * 
	 * @param speed
	 */
	public void spinClockwise(int speed){
		jniCreate.spinClockwise((short) speed);
	}
	
	/**
	 * 
	 * @param speed
	 */
	public void spinCounterClockwise(int speed){
		jniCreate.spinCounterClockwise((short) speed);
	}
	
	/**
	 * 
	 * @param distance
	 */
	public void setDistance(int distance){
		jniCreate.setDistance(distance);
	}
	
	/**
	 * 
	 * @param angle
	 */
	public void setAngle(int angle){
		jniCreate.setAngle(angle);
	}
}
