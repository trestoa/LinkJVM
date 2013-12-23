package linkjvm.low.factory;

import java.lang.ref.ReferenceQueue;

import linkjvm.low.buttons.Id;
import linkjvm.low.buttons.IdButton;

/**
 * 
 * @author Markus Klein
 *
 */
public class ButtonFactory extends AbstractMultiton<Id, IdButton>{

	public ButtonFactory(ReferenceQueue<IdButton> rq) {
		super(rq);
	}

	@Override
	protected IdButton getNewConcreteInstance(Id uniqueIdentifier) {
		return new IdButton(uniqueIdentifier, uniqueIdentifier.toString());
	}
	
}
