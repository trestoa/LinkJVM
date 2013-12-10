package linkjvm.high.sensors.buttons;

import linkjvm.low.buttons.IdButton;
import linkjvm.low.buttons.linkjvm_buttons;

public class YButton extends AbstractButton{

private IdButton jniButton;
	
	public YButton(){
		jniButton = linkjvm_buttons.getY();
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
