package linkjvm.low.factory;

import linkjvm.low.motors.Motor;

/**
 * 
 * @author Markus Klein
 *
 */
public class MotorFactory extends AbstractMultiton<Integer, Motor>{

	@Override
	protected Motor getNewConcreteInstance(Integer uniqueIdentifier) {
		return new Motor(uniqueIdentifier);
	}
	
}
