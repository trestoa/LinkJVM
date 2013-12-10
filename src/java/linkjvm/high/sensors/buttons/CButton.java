package linkjvm.high.sensors.buttons;

import linkjvm.low.buttons.IdButton;
import linkjvm.low.buttons.linkjvm_buttons;

class CButton extends AbstractButton{

private IdButton jniButton;
	
	public CButton(){
		jniButton = linkjvm_buttons.getC();
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
