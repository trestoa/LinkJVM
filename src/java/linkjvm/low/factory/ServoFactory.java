package linkjvm.low.factory;

import linkjvm.low.Servo;

/**
 * 
 * @author Markus Klein
 *
 */
public class ServoFactory extends AbstractMultiton<Integer, Servo>{

	@Override
	protected Servo getNewConcreteInstance(Integer uniqueIdentifier) {
		return new Servo(uniqueIdentifier);
	}
	
}
