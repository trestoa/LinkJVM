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
import linkjvm.low.vision.Device;
import linkjvm.low.vision.IntPoint2;
import linkjvm.low.vision.IntRectangle;

/**
 * This class is used to process images and to blob tracking.
 * @author Markus Klein
 * @version 2.1.0
 * @since 2.0.0
 */
public class ImageProcessor {
	private Device jniDevice;
	private int channel;
	
	/**
	 * Cunstructs a new ImageProcessor with the given {@link CameraConfig} and a channel number 
	 * @param cameraConfig the camera config
	 * @param channel the channel number
	 */
	public ImageProcessor(CameraConfig cameraConfig, int channel){
		jniDevice = JNIController.getInstance().getCameraFactory().getInstance(cameraConfig);
		jniDevice.setConfig(cameraConfig.getChannelConfig());
		jniDevice.setHeight(cameraConfig.getResolution().height);
		jniDevice.setWidth(cameraConfig.getResolution().width);
		this.channel = channel;
	}
	
	/**
	 * Opens the camera.
	 * @return <code>true</code> on success and <code>false</code> if an error occurs.
	 */
	public boolean openCamera(){
		return jniDevice.open();
	}
	
	/**
	 * Open a specific camera device.
	 * @param deviceNum
	 * @return
	 */
	public boolean openCamera(int deviceNum){
		return jniDevice.open(deviceNum);
	}
	
	/**
	 * Updates the camera image for foture processing
	 */
	public void update(){
		jniDevice.update();
	}
	
	/**
	 * Closes the connection to the camera.
	 */
	public void close(){
		jniDevice.close();
	}
	
	/**
	 * Returns the number of object with have been tracked.
	 * @return object count
	 */
	public long getObjectCount(){
		return jniDevice.channels().get(channel).objects().size();
	}
	
	/**
	 * Return the confidence of the object at the specified position.
	 * The objects are sorted in descending order according it's size.
	 * @param object object's position
	 * @return the object's confidence
	 */
	public double getObjectConfidence(int object){
		return jniDevice.channels().get(channel).objects().get(object).confidence();
	}
	
	/**
	 * Return the object at the specified position.
	 * The objects are sorted in descending order according it's size.
	 * @param object object's position
	 * @return the object
	 */
	public CameraObject getObject(int object){
		linkjvm.low.vision.Object jniObject = jniDevice.channels().get(channel).objects().get(object);
		return new CameraObject(toHighRectangle(jniObject.boundingBox()), toHighPoint(jniObject.centroid()), jniObject.confidence());
	}
	
	/**
	 * Return the centroid of the object at the specified position.
	 * The objects are sorted in descending order according it's size.
	 * @param object object's position
	 * @return the object's centroid
	 */
	public Point2 getCentroid(int object){
		return toHighPoint(jniDevice.channels().get(channel).objects().get(object).centroid());
	}
	
	/**
	 * Return the bounding box of the object at the specified position.
	 * The objects are sorted in descending order according it's size.
	 * @param object object's position
	 * @return the object's bounding box
	 */
	public Rectangle getBoundingBox(int object){
		IntRectangle jniRectangle = jniDevice.channels().get(channel).objects().get(object).boundingBox();
		return toHighRectangle(jniRectangle);
	}
	
	private Point2 toHighPoint(IntPoint2 jniPoint){ 
		return new Point2(jniPoint.x(), jniPoint.y());
	}
	
	private Rectangle toHighRectangle(IntRectangle jniRectangle){
		Rectangle ret = new Rectangle(jniRectangle.width(), jniRectangle.height(), jniRectangle.x(), jniRectangle.y(), toHighPoint(jniRectangle.center()));
		return ret;
	}
}
