package linkjvm.high.sensors.buttons;

import linkjvm.low.buttons.IdButton;
import linkjvm.low.buttons.linkjvm_buttons;

class BButton extends AbstractButton{
	
	private IdButton jniButton;
	
	public BButton(){
		jniButton = linkjvm_buttons.getB();
	}
	
	@Override
	public boolean getValue() {
		return jniButton.isPressed();
	}

}
