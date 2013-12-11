package linkjvm.high.sensors.buttons;

import linkjvm.low.buttons.ExtraButtons;

public class ButtonController {
	private static AButton aButton;
	private static BButton bButton;
	private static CButton cButton;
	private static XButton xButton;
	private static YButton yButton;
	private static ZButton zButton;
	private static SideButton sideButton;
	
	/**
	 * 
	 * @return
	 */
	public static AButton getAButton(){
		if(aButton == null) {
			aButton = new AButton();
		}
		return aButton;
	}
	
	/**
	 * 
	 * @return
	 */
	public static BButton getBButton(){
		if(bButton == null) {
			bButton = new BButton();
		}
		return bButton;
	}
	
	/**
	 * 
	 * @return
	 */
	public static CButton getCButton(){
		if(cButton == null) {
			cButton = new CButton();
		}
		return cButton;
	}
	
	/**
	 * 
	 * @return
	 */
	public static XButton getXButton(){
		if(xButton == null) {
			xButton = new XButton();
		}
		return xButton;
	}
	
	/**
	 * 
	 * @return
	 */
	public static YButton getYButton(){
		if(yButton == null) {
			yButton = new YButton();
		}
		return yButton;
	}
	
	/**
	 * 
	 * @return
	 */
	public static ZButton getZButton(){
		if(zButton == null) {
			zButton = new ZButton();
		}
		return zButton;
	}
	
	/**
	 * 
	 * @return
	 */
	public static SideButton getSideButton(){
		if(sideButton == null){
			sideButton = new SideButton();
		}
		return sideButton;
	}
	
	/**
	 * 
	 */
	public static void showExtraButtons(){
		ExtraButtons.show();
	}
	
	/**
	 * 
	 */
	public static void hideExtraButtons(){
		ExtraButtons.hide();
	}
	
	/**
	 * 
	 * @return
	 */
	public static boolean getExtraButtonsShown(){
		return ExtraButtons.isShown();
	}
	
	/**
	 * @param shown
	 */
	public static void setExtraButtonsDhown(boolean shown){
		ExtraButtons.setShown(shown);
	}
	
}
