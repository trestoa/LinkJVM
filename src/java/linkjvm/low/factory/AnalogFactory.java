package linkjvm.low.factory;

import linkjvm.low.analog.Analog;

/**
 * 
 * @author Markus Klein
 *
 */
public class AnalogFactory extends AbstractMultiton<Integer, Analog> {

	@Override
	protected Analog getNewConcreteInstance(Integer uniqueIdentifier) {
		return new Analog(uniqueIdentifier.shortValue());
	}

}
