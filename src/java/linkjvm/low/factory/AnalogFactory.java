package linkjvm.low.factory;

import java.lang.ref.ReferenceQueue;

import linkjvm.low.analog.Analog;

/**
 * 
 * @author Markus Klein
 *
 */
public class AnalogFactory extends AbstractMultiton<Integer, Analog> {

	public AnalogFactory(ReferenceQueue<Analog> rq) {
		super(rq);
	}

	@Override
	protected Analog getNewConcreteInstance(Integer uniqueIdentifier) {
		return new Analog(uniqueIdentifier.shortValue());
	}

}
