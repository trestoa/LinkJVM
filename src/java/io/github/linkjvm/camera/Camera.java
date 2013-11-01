package io.github.linkjvm.camera;

import io.github.linkjvm.jni.Device;
import io.github.linkjvm.jni.InputProvider;
import io.github.linkjvm.jni.UsbInputProvider;

public class Camera {
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

}
