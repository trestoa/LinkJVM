package linkjvm.low.factory;

public class JNIController implements Runnable{

	static {
		System.loadLibrary("linkjvmjni");
	}
	
	private final static JNIController instance = new JNIController();
	
	public static JNIController getInstance(){
		instance.startCleanup();
		return instance;
	}
	
	private final CreateFactory createFactory;
	
	private final AccelerationFactory accelerationFactory;
	private final AnalogFactory analogFactory;
	private final Analog8Factory analog8Factory;
	private final ButtonFactory buttonFactory;
	private final DigitalFactory digitalFactory;
	private final MotorFactory motorFactory;
	private final ServoFactory servoFactory;
	
	private volatile boolean stopCleanup = false;
	
	private Thread cleanupThread;
	
	/**
	 * 
	 */
	private JNIController(){
		accelerationFactory = new AccelerationFactory();
		analog8Factory = new Analog8Factory();
		analogFactory = new AnalogFactory();
		buttonFactory = new ButtonFactory();
		digitalFactory = new DigitalFactory();
		motorFactory = new MotorFactory();
		servoFactory = new ServoFactory();
		
		createFactory = new CreateFactory();
		cleanupThread = new Thread(this);
	}

	@Override
	public void run() {
		stopCleanup = false;
		while(stopCleanup){
			accelerationFactory.cleanup();
			analog8Factory.cleanup();
			analogFactory.cleanup();
			buttonFactory.cleanup();
			digitalFactory.cleanup();
			motorFactory.cleanup();
			servoFactory.cleanup();
		}		
	}
	
	/**
	 * 
	 */
	public void stopCleanup(){
		stopCleanup = true;
	}
	
	/**
	 * 
	 */
	public void startCleanup(){
		if(!cleanupThread.isAlive()){
			cleanupThread.start();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public CreateFactory getCreateFactory (){
		return createFactory;
	}
	
	/**
	 * 
	 * @return
	 */
	public AccelerationFactory getAccelerationFactory(){
		return accelerationFactory;
	}
	
	/**
	 * 
	 * @return
	 */
	public AnalogFactory getAnalogFactory(){
		return analogFactory;
	}
	
	/**
	 * 
	 * @return
	 */
	public Analog8Factory getAnalog8Factory(){
		return analog8Factory;
	}
	
	/**
	 * 
	 * @return
	 */
	public ButtonFactory getButtonFactory(){
		return buttonFactory;
	}
	
	/**
	 * 
	 * @return
	 */
	public DigitalFactory getDigitalFactory(){
		return digitalFactory;
	}
	
	/**
	 * 
	 * @return
	 */
	public MotorFactory getMotorFactory(){
		return motorFactory;
	}
	
	/**
	 * 
	 * @return
	 */
	public ServoFactory getServoFactory(){
		return servoFactory;
	}
}
