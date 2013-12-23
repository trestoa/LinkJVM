package linkjvm.low.factory;

import linkjvm.low.Digital;

/**
 * 
 * @author Markus Klein
 *
 */
public class DigitalFactory extends AbstractMultiton<Integer, Digital>{

	@Override
	protected Digital getNewConcreteInstance(Integer uniqueIdentifier) {
		return new Digital(uniqueIdentifier.shortValue());
	}
	
}
