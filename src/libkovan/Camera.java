package libkovan;

import libkovan.jni.Libkovan;


public class Camera {
	
	public Camera(int res){
		Libkovan.camera_open(res);
	}
	
	public int loadConfig(String name){
		return Libkovan.camera_load_config(name);
	}
	
	public int update(){
		return Libkovan.camera_update();
	}
	
	public int getChannelCount(){
		return Libkovan.get_channel_count();
	}
	
	public int getCodeNum(int channel, int obj){
		return Libkovan.get_code_num(channel, obj);
	}
	
	public int getObjectArea(int channel, int obj){
		return Libkovan.get_object_area(channel, obj);
	}
	
	public int getObjectCount(int channel){
		return Libkovan.get_object_count(channel);
	}
	
	public String getOjectData(int channel, int obj){
		return Libkovan.get_object_data(channel, obj);
	}
	
	public int getObjectDataLenght(int channel, int obj){
		return Libkovan.get_object_data_length(channel, obj);
	}
}
