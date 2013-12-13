package linkjvm.high.sensors.buttons;

import linkjvm.low.buttons.IdButton;
import linkjvm.low.buttons.linkjvm_buttons;

class XButton extends AbstractButton implements TextButton{

private IdButton jniButton;
	
	public XButton(){
		jniButton = linkjvm_buttons.getX();
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
