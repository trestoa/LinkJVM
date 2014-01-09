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
package linkjvm.high.vision;

import linkjvm.low.camera.Device;
import linkjvm.low.camera.InputProvider;
import linkjvm.low.camera.UsbInputProvider;
import linkjvm.low.factory.JNIController;

/**
 * 
 * @author Christoph Hackenberger
 * @version 2.0.0
 * @since 2.0.0
 * 
 * Represents a Camera object for 2D-camera with a specific InputProvider.
 */
public class Camera {
	
	private volatile Device jniCamera;
	
	public Camera() {
		this(new UsbInputProvider());
	}
	
	public Camera(InputProvider ip) {
		this(ip, Resolution.MED_RES);
	}
	
	public Camera(Resolution res) {
		this(new UsbInputProvider(), res);
	}
	
	public Camera(InputProvider ip, Resolution res) {
		jniCamera = JNIController.getInstance().getCameraFactory().getInstance(ip);
		jniCamera.setWidth(res.width);
		jniCamera.setHeight(res.height);
	}
	
	public boolean open() {
		return jniCamera.open();
	}
	
	public boolean open(int number) {
		return jniCamera.open(number);
	}
	
	public boolean isOpen() {
		return jniCamera.isOpen();
	}
	
	public boolean close() {
		return jniCamera.close();
	}
	
	public boolean update() {
		return jniCamera.update();
	}
	
	public long width() {
		return jniCamera.width();
	}
	
	public long height() {
		return jniCamera.height();
	}
}
