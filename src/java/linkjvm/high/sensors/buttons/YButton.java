package linkjvm.high.sensors.buttons;

import linkjvm.low.buttons.IdButton;
import linkjvm.low.buttons.linkjvm_buttons;

class YButton extends AbstractButton{

private IdButton jniButton;
	
	public YButton(){
		jniButton = linkjvm_buttons.getY();
	}

	@Override
	public boolean getValue() {
		return jniButton.isPressed();
	}

}
