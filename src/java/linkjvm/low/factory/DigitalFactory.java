package linkjvm.low.factory;

import java.lang.ref.ReferenceQueue;

import linkjvm.low.Digital;

/**
 * 
 * @author Markus Klein
 *
 */
public class DigitalFactory extends AbstractMultiton<Integer, Digital>{

	public DigitalFactory(ReferenceQueue<Digital> rq) {
		super(rq);
	}

	@Override
	protected Digital getNewConcreteInstance(Integer uniqueIdentifier) {
		return new Digital(uniqueIdentifier.shortValue());
	}
	
}
