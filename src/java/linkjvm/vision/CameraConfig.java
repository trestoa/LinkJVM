/*
 * This file is part of LinkJVM.
 *
 * Java Framework for the KIPR Link
 * Copyright (C) 2014 LinkJVM
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

package linkjvm.vision;

import linkjvm.low.factory.JNIController;
import linkjvm.low.vision.Config;
import linkjvm.low.vision.InputProvider;

/**
 * An instance of this object represents a camera configuration.
 * Every camera consists out of 3 components:
 * <ul>
 * 	<li>InputProvider: The input provider provides the raw image.</li>
 * 	<li>Resolution: The resulution specifies the resolution for the processed image.</li>
 * 	<li>ChannelConfig: The channel config offers configuration for the image processing.</li>
 * </ul>
 * @author Markus Klein
 * @version 2.1.0
 * @since 2.0.0
 */
public class CameraConfig {
	
	/**
	 * If no other channel config name is specified, this default channel config will be used.
	 */
	public static final String DEFAULT_CHANNEL_CONFIG_NAME = "default";
	
	private final Resolution res;
	private final InputProvider inputProvider;
	private final Config channelConfig;
	
	/**
	 * Constructs a new camera config with the given resolution, input provider and channel config.
	 * @param res camera resolution
	 * @param inputProvider input provider
	 * @param channelConfigName channel configuration name
	 */
	public CameraConfig(Resolution res, InputProvider inputProvider, String channelConfigName) {
		super();
		this.res = res;
		this.inputProvider = inputProvider;
		this.channelConfig = JNIController.getInstance().getConfigFactory().getInstance(channelConfigName);
	}
	
	/**
	 * Constructs a new camera config with the given input provider and channel configuration.
	 * It uses the default resolution.
	 * @param inputProvider input provider
	 * @param channelConfigName channel configuration name
	 */
	public CameraConfig(InputProvider inputProvider, String channelConfigName) {
		this(Resolution.MED_RES, inputProvider, channelConfigName);
	}
	
	/**
	 * Constructs a new camera config with the given input provider and resolution.
	 * It uses the default input provider.
	 * @param res resolution
	 * @param channelConfigName channel configuration
	 */
	public CameraConfig(Resolution res, String channelConfigName){
		this(res, JNIController.getInstance().getUsbInputProviderFactory().getInstance(), channelConfigName);
	}
	
	/**
	 * Constructs a new camera config with the given resolution.
	 * It uses the default input provider and the default channel configuration.
	 * @param res resolution
	 */
	public CameraConfig(Resolution res){
		this(res, JNIController.getInstance().getUsbInputProviderFactory().getInstance(), DEFAULT_CHANNEL_CONFIG_NAME);
	}
	
	/**
	 * Constructs a new camera config with the given input provider.
	 * It uses the default channel configuration and the resolution.
	 * @param inputProvider input provider
	 */
	public CameraConfig(InputProvider inputProvider){
		this(Resolution.MED_RES, inputProvider, DEFAULT_CHANNEL_CONFIG_NAME);
	}
	
	/**
	 * Constructs a new camera config with the given channel configuration.
	 * It uses the default input provider and the default resolution.
	 * @param channelConfigName channel configuration
	 */
	public CameraConfig(String channelConfigName){
		this(Resolution.MED_RES, JNIController.getInstance().getUsbInputProviderFactory().getInstance(), channelConfigName);
	}
	
	/**
	 * Cunstructs a new camera config with all default values.
	 */
	public CameraConfig(){
		this(Resolution.MED_RES, JNIController.getInstance().getUsbInputProviderFactory().getInstance(), DEFAULT_CHANNEL_CONFIG_NAME);
	}

	/**
	 * Returns the resolution.
	 * @return resolution
	 */
	public Resolution getResolution() {
		return res;
	}

	/**
	 * Returns the input provider.
	 * @return input provider
	 */
	public InputProvider getInputProvider() {
		return inputProvider;
	}
	
	/**
	 * Return the channel configuration.
	 * @return channel configuration
	 */
	public Config getChannelConfig(){
		return channelConfig;
	}
	
	
}
