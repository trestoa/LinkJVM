package linkjvm.high.sensors.buttons;

import linkjvm.low.buttons.IdButton;
import linkjvm.low.buttons.linkjvm_buttons;

class CButton extends AbstractButton implements TextButton{

private IdButton jniButton;
	
	public CButton(){
		jniButton = linkjvm_buttons.getC();
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
