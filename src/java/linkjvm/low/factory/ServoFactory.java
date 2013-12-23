package linkjvm.low.factory;

import java.lang.ref.ReferenceQueue;

import linkjvm.low.Servo;

/**
 * 
 * @author Markus Klein
 *
 */
public class ServoFactory extends AbstractMultiton<Integer, Servo>{

	public ServoFactory(ReferenceQueue<Servo> rq) {
		super(rq);
	}

	@Override
	protected Servo getNewConcreteInstance(Integer uniqueIdentifier) {
		return new Servo(uniqueIdentifier);
	}
	
}
