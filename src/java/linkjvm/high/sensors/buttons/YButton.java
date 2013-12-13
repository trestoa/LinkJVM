package linkjvm.high.sensors.buttons;

import linkjvm.low.buttons.IdButton;
import linkjvm.low.buttons.linkjvm_buttons;

class YButton extends AbstractButton implements TextButton{

private IdButton jniButton;
	
	public YButton(){
		jniButton = linkjvm_buttons.getY();
	}

	@Override
	public boolean getValue() {
		return jniButton.isPressed();
	}

	@Override
	public void setText(String text) {
		jniButton.setText(text);
	}

	@Override
	public String getText() {
		return jniButton.text();
	}
}
