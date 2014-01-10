package linkjvm.low.factory;

import linkjvm.low.vision.XtionDepthDriver;

/**
 * 
 * @author Markus Klein
 *
 */
public class DepthFactory {
	
	/**
	 * 
	 * @return
	 */
	public XtionDepthDriver getInstance(){
		return XtionDepthDriver.instance();
	}
}
