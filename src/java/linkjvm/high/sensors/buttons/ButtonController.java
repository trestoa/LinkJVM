/*
 * This file is part of LinkJVM.
 *
 * Java Framework for the KIPR Link
 * Copyright (C) 2013 Markus Klein<m@mklein.co.at>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

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
