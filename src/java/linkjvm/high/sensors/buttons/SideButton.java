package linkjvm.high.sensors.buttons;

import linkjvm.low.buttons.IdButton;
import linkjvm.low.buttons.linkjvm_buttons;

public class SideButton extends AbstractButton {

	private IdButton jniButton;
	
	public SideButton(){
		jniButton = linkjvm_buttons.getSide();
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
