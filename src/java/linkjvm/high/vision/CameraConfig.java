package linkjvm.high.vision;

import linkjvm.low.factory.JNIController;
import linkjvm.low.vision.Config;
import linkjvm.low.vision.InputProvider;

/**
 * 
 * @author Markus Klein
 *
 */
public class CameraConfig {
	
	/**
	 * 
	 */
	public static final String DEFAULT_CHANNEL_CONFIG_NAME = "default";
	
	private final Resolution res;
	private final InputProvider inputProvider;
	private final Config channelConfig;
	
	/**
	 * 
	 * @param res
	 * @param inputProvider
	 */
	public CameraConfig(Resolution res, InputProvider inputProvider, String channelConfigName) {
		super();
		this.res = res;
		this.inputProvider = inputProvider;
		this.channelConfig = JNIController.getInstance().getConfigFactory().getInstance(channelConfigName);
	}
	
	/**
	 * 
	 * @param inputProvider
	 */
	public CameraConfig(InputProvider inputProvider, String channelConfigName) {
		this(Resolution.MED_RES, inputProvider, channelConfigName);
	}
	
	/**
	 * 
	 * @param res
	 */
	public CameraConfig(Resolution res, String channelConfigName){
		this(res, JNIController.getInstance().getUsbInputProviderFactory().getInstance(), channelConfigName);
	}
	
	/**
	 * 
	 * @param res
	 */
	public CameraConfig(Resolution res){
		this(res, JNIController.getInstance().getUsbInputProviderFactory().getInstance(), DEFAULT_CHANNEL_CONFIG_NAME);
	}
	
	/**
	 * 
	 * @param inputProvider
	 */
	public CameraConfig(InputProvider inputProvider){
		this(Resolution.MED_RES, inputProvider, DEFAULT_CHANNEL_CONFIG_NAME);
	}
	
	/**
	 * 
	 * @param channelConfigName
	 */
	public CameraConfig(String channelConfigName){
		this(Resolution.MED_RES, JNIController.getInstance().getUsbInputProviderFactory().getInstance(), channelConfigName);
	}
	
	/**
	 * 
	 */
	public CameraConfig(){
		this(Resolution.MED_RES, JNIController.getInstance().getUsbInputProviderFactory().getInstance(), DEFAULT_CHANNEL_CONFIG_NAME);
	}

	/**
	 * 
	 * @return
	 */
	public Resolution getResolution() {
		return res;
	}

	/**
	 * 
	 * @return
	 */
	public InputProvider getInputProvider() {
		return inputProvider;
	}
	
	/**
	 * 
	 * @return
	 */
	public Config getChannelConfig(){
		return channelConfig;
	}
	
	
}
