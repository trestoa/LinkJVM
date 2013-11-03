package io.github.linkjvm.camera;

import io.github.linkjvm.jni.camera.*;

public class Camera{
	private Device cameraDevice;

	/**
	 *
	 * @param ip
	 * @param res
	 */
	public Camera(InputProvider ip, CameraResolution res){
		cameraDevice = new Device(ip);
		cameraDevice.open();
		cameraDevice.setHeight((long) res.getHeight());
		cameraDevice.setWidth((long) res.getWidth());
	}

	/**
	 *
	 * @param res
	 */
	public Camera(CameraResolution res){
		this(new UsbInputProvider(), res);
	}

	/**
	 *
	 * @param ip
	 */
	public Camera(InputProvider ip){
		this(ip, CameraResolution.medResolution);
	}

	/**
	 *
	 */
	public Camera(){
		this(new UsbInputProvider(), CameraResolution.medResolution);
	}

	/**
	 *
	 * @param name
	 * @return
	 */
	public boolean setConfig(String name){
		Config config = Config.load(ConfigPath.path(name));
		if(config == null){
			return false;
		}
		cameraDevice.setConfig(config);
		config.delete();
		return true;
	}

	/**
	 *
	 * @return
	 */
	public Config getConfig(){
		return cameraDevice.config();
	}

	/**
	 *
	 * @return
	 */
	public boolean update(){
		return cameraDevice.update();
	}

	/**
	 *
	 * @return
	 */
	public int getObjectCount(){
		return (int) cameraDevice.channels().size();
	}

	public Frame getFrame(){
		cameraDevice.channels().get(0).
		return new Frame();

	}

}
