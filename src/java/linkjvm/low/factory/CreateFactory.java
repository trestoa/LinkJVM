package linkjvm.low.factory;

import linkjvm.low.create.Create;

/**
 * 
 * @author Markus Klein
 *
 */
public class CreateFactory{

	public Create getInstance() {
		return Create.instance();
	}

}
