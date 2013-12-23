package linkjvm.low.factory;

import java.lang.ref.ReferenceQueue;

import linkjvm.low.analog.Analog8;

/**
 * 
 * @author Markus Klein
 *
 */
public class Analog8Factory extends AbstractMultiton<Integer, Analog8> {

	public Analog8Factory(ReferenceQueue<Analog8> rq) {
		super(rq);
	}

	@Override
	protected Analog8 getNewConcreteInstance(Integer uniqueIdentifier) {
		return new Analog8(uniqueIdentifier.shortValue());
	}

}
