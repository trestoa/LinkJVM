package linkjvm.high.sensors.buttons;

import linkjvm.low.buttons.IdButton;
import linkjvm.low.buttons.linkjvm_buttons;

class AButton extends AbstractButton{
	private IdButton jniButton;
	
	public AButton(){
		jniButton = linkjvm_buttons.getA();
	}
	
	@Override
	public boolean isPressed() {
		return jniButton.isPressed();
	}

	@Override
	public boolean getValue() {
		return isPressed();
	}

}
