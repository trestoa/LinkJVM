/*
* This file is part of LinkJVM Java.
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

package old.linkjvm.libkovan;

import old.linkjvm.libkovan.jni.LinkJVM;
import old.linkjvm.libkovan.jni.Resolution;

/**
 * This class is used to control the camera.
 * 
 * @author Markus Klein
 * @version 1.0.0
 */

public class Camera {
	
	public static final int LOW_RES = 0;
	public static final int MED_RES = 1;
	public static final int HIGH_RES = 2;
	
	/**
	 * Creates a new camera instance and opens the camera with the specified resolution and the standard configuration.
	 * 
	 * @param res
	 */
	public Camera(int res){
		Resolution cameraRes;
		if(res == LOW_RES){
			cameraRes = Resolution.LOW_RES;
		}
		else if(res == MED_RES){
			cameraRes = Resolution.MED_RES;
		}
		else if(res == HIGH_RES){
			cameraRes = Resolution.HIGH_RES;
		}
		else{
			cameraRes = null;
		}
		LinkJVM.camera_open(cameraRes);
	}
	
	/**
	 * Loads an other configuration file on the KIPR Link than the standard configuration. 
	 * 
	 * @param name name of the configuration file (".config" must be appended!)
	 * @return 1 on success and 0 on failure
	 */
	public int loadConfig(String name){
		return LinkJVM.camera_load_config(name);
	}
	
	/**
	 * Loads a new image from the camera for processing.
	 * 
	 * @return 1 on success and 0 on failure
	 */
	public int update(){
		return LinkJVM.camera_update();
	}
	
	/**
	 * Returns the number of channels in the current configuration.
	 * 
	 * @return number of channels
	 */
	public int getChannelCount(){
		return LinkJVM.get_channel_count();
	}
	
	/**
	 * Returns the data associated with the channel and the object.
	 * 
	 * @param channel channel
	 * @param obj object
	 * @return data associated with the channel and the object, 1 failure
	 */
	public int getCodeNum(int channel, int obj){
		return LinkJVM.get_code_num(channel, obj);
	}
	
	/**
	 * Returns the object�s bounding box area.
	 * 
	 * @param channel channel
	 * @param obj object
	 * @return bounding box area or -1 if the channel of the object does not exist
	 */
	public int getObjectArea(int channel, int obj){
		return LinkJVM.get_object_area(channel, obj);
	}
	
	/**
	 * Returns the number of objects that have been seen with the current configuration and the specified channel.
	 * 
	 * @param channel channel
	 * @return number of channels
	 */
	public int getObjectCount(int channel){
		return LinkJVM.get_object_count(channel);
	}
	
	/**
	 * This method is used to get the decoded data as string from a QR code channel and the specified object.
	 * 
	 * @param channel QR channel
	 * @param obj object
	 * @return data
	 */
	public String getOjectData(int channel, int obj){
		return LinkJVM.get_object_data(channel, obj);
	}
	
	/**
	 * Returns the length of the QR code decoded string of the QR channel and the specified object.
	 * 
	 * @param channel
	 * @param obj
	 * @return length of the data string
	 */
	public int getObjectDataLenght(int channel, int obj){
		return LinkJVM.get_object_data_length(channel, obj);
	}
}
