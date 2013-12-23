package linkjvm.low.factory;

import linkjvm.low.buttons.Id;
import linkjvm.low.buttons.IdButton;

/**
 * 
 * @author Markus Klein
 *
 */
public class ButtonFactory extends AbstractMultiton<Id, IdButton>{

	@Override
	protected IdButton getNewConcreteInstance(Id uniqueIdentifier) {
		return new IdButton(uniqueIdentifier, uniqueIdentifier.toString());
	}
	
}
