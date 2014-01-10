package linkjvm.high.vision.depth;

import linkjvm.low.factory.JNIController;
import linkjvm.low.vision.DepthDriver;

/**
 * 
 * @author Markus Klein
 *
 */
public class DepthCamera {
	private DepthDriver jniDepthCamera;
	
	/**
	 * 
	 */
	public DepthCamera(){
		this(JNIController.getInstance().getDepthFactory().getInstance(), DepthResolution.LOW_RES);
	}
	
	/**
	 * 
	 * @param driver
	 */
	public DepthCamera(DepthDriver driver){
		this(driver, DepthResolution.LOW_RES);
	}
	
	/**
	 * 
	 * @param res
	 */
	public DepthCamera(DepthResolution res){
		this(JNIController.getInstance().getDepthFactory().getInstance(), res);
	}
	
	/**
	 * 
	 * @param driver
	 * @param res
	 */
	public DepthCamera(DepthDriver driver, DepthResolution res){
		jniDepthCamera = driver;
		setResolution(res);
	}
	
	/**
	 * 
	 */
	public void open(){
		jniDepthCamera.open();
	}
	
	/**
	 * 
	 * @param res
	 */
	public void open(DepthResolution res){
		jniDepthCamera.open();
		
	}
	
	/**
	 * 
	 * @param resolution
	 */
	public void setResolution(DepthResolution resolution){
		switch(resolution){
		case LOW_RES:
			jniDepthCamera.setDepthCameraResolution(linkjvm.low.vision.DepthResolution.DEPTH_RESOLUTION_320_240);
			break;
		case HIGH_RES:
			jniDepthCamera.setDepthCameraResolution(linkjvm.low.vision.DepthResolution.DEPTH_RESOLUTION_640_480);
			break;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public DepthResolution getResolution(){
		if(jniDepthCamera.depthCameraResolution() == linkjvm.low.vision.DepthResolution.DEPTH_RESOLUTION_320_240){
			return DepthResolution.LOW_RES;
		}
		else if(jniDepthCamera.depthCameraResolution() == linkjvm.low.vision.DepthResolution.DEPTH_RESOLUTION_640_480){
			return DepthResolution.HIGH_RES;
		}
		else{
			return null;
		}
	}
	
	public boolean isOpen(){
		return jniDepthCamera.isOpen();
	}	
	
}
