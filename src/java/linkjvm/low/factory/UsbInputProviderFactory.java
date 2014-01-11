package linkjvm.low.factory;

import linkjvm.low.vision.UsbInputProvider;

public class UsbInputProviderFactory implements ISingleton<UsbInputProvider>{
	private UsbInputProvider usbInputProvider;
	
	/**
	 * 
	 */
	@Override
	public UsbInputProvider getInstance() {
		if(usbInputProvider == null){
			usbInputProvider = new UsbInputProvider();
		}
		return usbInputProvider;
	}
	
}
