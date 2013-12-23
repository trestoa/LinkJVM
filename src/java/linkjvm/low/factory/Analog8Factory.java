package linkjvm.low.factory;

import linkjvm.low.analog.Analog8;

/**
 * 
 * @author Markus Klein
 *
 */
public class Analog8Factory extends AbstractMultiton<Integer, Analog8> {

	@Override
	protected Analog8 getNewConcreteInstance(Integer uniqueIdentifier) {
		return new Analog8(uniqueIdentifier.shortValue());
	}

}
