package linkjvm.low.factory;

import java.lang.ref.ReferenceQueue;

import linkjvm.low.motors.Motor;

/**
 * 
 * @author Markus Klein
 *
 */
public class MotorFactory extends AbstractMultiton<Integer, Motor>{

	public MotorFactory(ReferenceQueue<Motor> rq) {
		super(rq);
	}

	@Override
	protected Motor getNewConcreteInstance(Integer uniqueIdentifier) {
		return new Motor(uniqueIdentifier);
	}
	
}
