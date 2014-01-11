/*
 * This file is part of LinkJVM.
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

/*
 *
 * Copyright (c) <2011>, <Shigeo Yoshida>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * The names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package linkjvm.high.ardrone;

//import java.awt.image.BufferedImage;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import linkjvm.high.ardrone.command.CommandManager;
import linkjvm.high.ardrone.listeners.AttitudeListener;
import linkjvm.high.ardrone.listeners.BatteryListener;
import linkjvm.high.ardrone.listeners.NavDataListener;
import linkjvm.high.ardrone.listeners.StateListener;
import linkjvm.high.ardrone.listeners.VelocityListener;
import linkjvm.high.ardrone.navdata.DroneState;
import linkjvm.high.ardrone.navdata.NavDataManager;
import linkjvm.high.ardrone.navdata.javadrone.NavData;
import linkjvm.high.ardrone.utils.ARDroneUtils;



public class ARDrone implements ARDroneInterface{

	/** default ip address */
	private static final String IP_ADDRESS="192.168.1.1";

	private String ipaddr=null; 
	private InetAddress inetaddr=null;

	//managers
	private CommandManager manager=null;
//	private VideoManager videoManager=null;
	private NavDataManager navdataManager=null;

	//listeners	
	private ArrayList<AttitudeListener> attitudeListeners = null;
	private ArrayList<BatteryListener> batteryListeners = null; 
	private ArrayList<StateListener> stateListeners = null;
	private ArrayList<VelocityListener> velocityListeners = null;
	private ArrayList<NavDataListener> navDataListeners = null;

	/** constructor */
	public ARDrone(){
		this(IP_ADDRESS);
	}
	/**
	 * constructor
	 * @param ipaddr
	 */
	public ARDrone(String ipaddr){
		this.ipaddr=ipaddr;
	}

	/** connect to AR.Drone */
	@Override
	public boolean connect() {
		if(inetaddr==null){
			inetaddr=getInetAddress(ipaddr);
		}
		manager=new CommandManager(inetaddr);
		return manager.connect(ARDroneUtils.PORT);
	}

	/** connect video */
	@Override
	public boolean connectVideo() {
		/*if(inetaddr==null){
			inetaddr=getInetAddress(ipaddr);
		}
		videoManager=new VideoManager(inetaddr, manager);
		videoManager.setImageListener(new ImageListener() {
			@Override
			public void imageUpdated(BufferedImage image) {
				if(imageListener!=null){
					imageListener.imageUpdated(image);
				}
			}
		});
		return videoManager.connect(ARDroneUtils.VIDEO_PORT);*/
		return false;
	}

	/** connect navdata */
	@Override
	public boolean connectNav() {
		if(inetaddr==null){
			inetaddr=getInetAddress(ipaddr);
		}
		attitudeListeners = new ArrayList<AttitudeListener>();
		batteryListeners = new ArrayList<BatteryListener>();
		stateListeners = new ArrayList<StateListener>();
		velocityListeners = new ArrayList<VelocityListener>();
		navDataListeners = new ArrayList<NavDataListener>();
		navdataManager=new NavDataManager(inetaddr, manager);
		navdataManager.setAttitudeListener(new AttitudeListener() {
			@Override
			public void attitudeUpdated(float pitch, float roll, float yaw, int altitude) {
				Iterator<AttitudeListener> it = attitudeListeners.iterator();
				while(it.hasNext()){
					it.next().attitudeUpdated(pitch, roll, yaw, altitude);
				}
			}
		});
		navdataManager.setBatteryListener(new BatteryListener() {
			@Override
			public void batteryLevelChanged(int percentage) {
				Iterator<BatteryListener> it = batteryListeners.iterator();
				while(it.hasNext()){
					it.next().batteryLevelChanged(percentage);
				}
			}
		});
		navdataManager.setStateListener(new StateListener() {
			@Override
			public void stateChanged(DroneState state) {
				Iterator<StateListener> it = stateListeners.iterator();
				while(it.hasNext()){
					it.next().stateChanged(state);
				}
			}
		});

		navdataManager.setVelocityListener(new VelocityListener() {
			@Override
			public void velocityChanged(float vx, float vy, float vz) {
				Iterator<VelocityListener> it = velocityListeners.iterator();
				while(it.hasNext()){
					it.next().velocityChanged(vx, vy, vz);
				}
			}
		});
		navdataManager.setNavDataListener(new NavDataListener() {
			@Override
			public void navDataUpdated(NavData navData) {
				Iterator<NavDataListener> it = navDataListeners.iterator();
				while(it.hasNext()){
					it.next().navDataUpdated(navData);
				}
			}
		});

		return navdataManager.connect(ARDroneUtils.NAV_PORT);
	}

	@Override
	public void disconnect() {
		stop();
		landing();
		manager.close();
//		if(videoManager!=null)
//			videoManager.close();
		if(navdataManager!=null)
			navdataManager.close();
	}

	@Override
	public void start() {
		if(manager!=null)
			new Thread(manager).start();
//		if(videoManager!=null)
//			new Thread(videoManager).start();
		if(navdataManager!=null)
			new Thread(navdataManager).start();
	}

	@Override
	public void setHorizontalCamera() {
		if(manager!=null)
			manager.setHorizontalCamera();
	}

	@Override
	public void setVerticalCamera() {
		if(manager!=null)
			manager.setVerticalCamera();
	}

	@Override
	public void setHorizontalCameraWithVertical() {
		if(manager!=null)
			manager.setHorizontalCameraWithVertical();
	}

	@Override
	public void setVerticalCameraWithHorizontal() {
		if(manager!=null)
			manager.setVerticalCameraWithHorizontal();
	}

	@Override
	public void toggleCamera() {
		if(manager!=null)
			manager.toggleCamera();
	}

	@Override
	public void landing() {
		if(manager!=null)
			manager.landing();
	}

	@Override
	public void takeOff() {
		if(manager!=null)
			manager.takeOff();
	}

	@Override
	public void reset() {
		if(manager!=null)
			manager.reset();
	}

	@Override
	public void forward() {
		if(manager!=null)
			manager.forward();
	}

	@Override
	public void forward(int speed) {
		if(manager!=null)
			manager.forward(speed);
	}

	@Override
	public void backward() {
		if(manager!=null)
			manager.backward();
	}

	@Override
	public void backward(int speed) {
		if(manager!=null)
			manager.backward(speed);
	}

	@Override
	public void spinRight() {
		if(manager!=null)
			manager.spinRight();
	}

	@Override
	public void spinRight(int speed) {
		if(manager!=null)
			manager.spinRight(speed);
	}

	@Override
	public void spinLeft() {
		if(manager!=null)
			manager.spinLeft();
	}

	@Override
	public void spinLeft(int speed) {
		if(manager!=null)
			manager.spinLeft(speed);
	}

	@Override
	public void up() {
		if(manager!=null)
			manager.up();
	}

	@Override
	public void up(int speed) {
		if(manager!=null)
			manager.up(speed);
	}

	@Override
	public void down() {
		if(manager!=null)
			manager.down();
	}

	@Override
	public void down(int speed) {
		if(manager!=null)
			manager.down(speed);
	}

	@Override
	public void goRight() {
		if(manager!=null)
			manager.goRight();
	}

	@Override
	public void goRight(int speed) {
		if(manager!=null)
			manager.goRight(speed);
	}

	@Override
	public void goLeft() {
		if(manager!=null)
			manager.goLeft();
	}

	@Override
	public void goLeft(int speed) {
		if(manager!=null)
			manager.goLeft(speed);
	}

	@Override
	public void setSpeed(int speed) {
		if(manager!=null)
			manager.setSpeed(speed);
	}

	@Override
	public void stop() {
		if(manager!=null)
			manager.stop();
	}

	/**
	 * 0.01-1.0 -> 1-100%
	 * @return 1-100%
	 */
	@Override
	public int getSpeed() {
		if(manager==null)
			return -1;
		return manager.getSpeed();
	}

	@Override
	public void setMaxAltitude(int altitude){
		if(manager!=null)
			manager.setMaxAltitude(altitude);
	}

	@Override
	public void setMinAltitude(int altitude){
		if(manager!=null)
			manager.setMinAltitude(altitude);
	}

	@Override
	public void move3D(int speedX, int speedY, int speedZ, int speedSpin) {
		if(manager!=null)
			manager.move3D(speedX, speedY, speedZ, speedSpin);
	}

	//update listeners
	/*public void addImageUpdateListener(ImageListener imageListener){
		this.imageListener=imageListener;
	}*/
	public void addAttitudeUpdateListener(AttitudeListener attitudeListener){
		attitudeListeners.add(attitudeListener);
	}
	public void addBatteryUpdateListener(BatteryListener batteryListener){
		batteryListeners.add(batteryListener); 
	}
	public void addStateUpdateListener(StateListener stateListener){
		stateListeners.add(stateListener);
	}
	public void addVelocityUpdateListener(VelocityListener velocityListener){
		velocityListeners.add(velocityListener);
	}
	public void addNavDataListener(NavDataListener navDataListener)	{
		navDataListeners.add(navDataListener);
	}
	//remove listeners
	/*public void removeImageUpdateListener(){
		imageListener=null;
	}*/
	public void removeAttitudeUpdateListener(AttitudeListener l){
		attitudeListeners.remove(l);
	}
	public void removeBatteryUpdateListener(BatteryListener l){
		batteryListeners.remove(l);
	}
	public void removeStateUpdateListener(StateListener l){
		stateListeners.remove(l);
	}
	public void removeVelocityUpdateListener(VelocityListener l){
		velocityListeners.remove(l);
	}
	public void removeNavDataListener(NavDataListener l){
		navDataListeners.remove(l);
	}

	/**
	 * print error message
	 * @param message
	 * @param obj
	 */
	public static void error(String message, Object obj){
		System.err.println("["+obj.getClass()+"] "+message);
	}

	private InetAddress getInetAddress(String ipaddr){
		InetAddress inetaddr=null;
		StringTokenizer st=new StringTokenizer(ipaddr, ".");
		byte[] ipBytes=new byte[4];
		if(st.countTokens()==4){
			for(int i=0; i<4; i++){
				ipBytes[i]=(byte) Integer.parseInt(st.nextToken());
			}
		}else{
			error("Incorrect IP address format: "+ipaddr, this);
			return null;
		}
		try {
			inetaddr=InetAddress.getByAddress(ipBytes);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return inetaddr;
	}
}