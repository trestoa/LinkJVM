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

package libkovan;

import libkovan.jni.LinkJVM;

/**
 * An instance of this class is used to control thie iRobot create with the KIPR Link.
 * 
 * @author Markus Klein
 * @version 1.0.0
 */

public class Create {
	public static final int MODE = 0;
	public static final int LBUMP = 1;
	public static final int RBUMP = 2;
	public static final int LWDROP = 3;
	public static final int CWDROP = 4;
	public static final int RWDROP = 5;
	public static final int WALL = 6;
	public static final int LCLIFF = 7;
	public static final int LFCLIFF = 8;
	public static final int RFCLIFF = 9;
	public static final int RCLIFF = 10;
	public static final int VWALL = 11;
	public static final int OVERCURRENTS = 12;
	public static final int INFRARED = 13;
	public static final int ADVANCE_BUTTON = 14;
	public static final int PLAY_BUTTON = 15;
	public static final int NORMALIZED_ANGLE = 16;
	public static final int TOTAL_ANGLE = 17;
	public static final int DISTANCE = 18;
	public static final int BATTERY_CHARGING_STATE = 19;
	public static final int BATTERY_VOLTAGE = 20;
	public static final int BATTERY_CURRENT = 21;
	public static final int BATTERY_TEMP = 22;
	public static final int BATTERY_CHARGE = 23;
	public static final int BATTERY_CAPACITY = 24;
	public static final int WALL_AMT = 25;
	public static final int LCLIFF_AMT = 26;
	public static final int LFCLIFF_AMT = 27;
	public static final int RFCLIFF_AMT = 28;
	public static final int RCLIFF_AMT = 29;
	public static final int BAY_DI = 30;
	public static final int BAY_AI = 31;
	public static final int SONG_NUMBER = 32;
	public static final int SONG_PLAYING = 33;
	public static final int NUMBER_OF_STREAM_PACKETS = 34;
	public static final int REQUESTED_VELOCITY = 35;
	public static final int REQUESTED_RADIUS = 36;
	public static final int REQUESTED_RIGHT_VELOCITY = 37;
	public static final int REQUESTED_LEFT_VELOCITY = 38;
	
	/**
	 * Creates a new create instance and opens the connection to the create.
	 */
	public Create(){
		LinkJVM.create_connect();
	}
	
	/**
	 * Sets the create to the active mode.
	 */
	public void start(){
		LinkJVM.create_start();
	}
	
	/**
	 * This function is used to get different data from the create.
	 * 
	 * @param val
	 * @return value of the specified data
	 */
	public int get(int val){
		switch(val){
		case MODE:
			return LinkJVM.get_create_mode();
		case LBUMP:
			return LinkJVM.get_create_lbump();
		case RBUMP:
			return LinkJVM.get_create_rbump();
		case LWDROP:
			return LinkJVM.get_create_lwdrop();
		case CWDROP:
			return LinkJVM.get_create_cwdrop();
		case RWDROP:
			return LinkJVM.get_create_rwdrop();
		case WALL:
			return LinkJVM.get_create_wall();
		case LCLIFF:
			return LinkJVM.get_create_lcliff();
		case LFCLIFF:
			return LinkJVM.get_create_lfcliff();
		case RFCLIFF:
			return LinkJVM.get_create_rfcliff();
		case RCLIFF:
			return LinkJVM.get_create_rcliff();
		case VWALL:
			return LinkJVM.get_create_vwall();
		case OVERCURRENTS:
			return LinkJVM.get_create_overcurrents();
		case INFRARED:
			return LinkJVM.get_create_infrared();
		case ADVANCE_BUTTON:
			return LinkJVM.get_create_advance_button();
		case PLAY_BUTTON:
			return LinkJVM.get_create_play_button();
		case NORMALIZED_ANGLE:
			return LinkJVM.get_create_normalized_angle();
		case TOTAL_ANGLE:
			return LinkJVM.get_create_total_angle();
		case DISTANCE:
			return LinkJVM.get_create_distance();
		case BATTERY_CHARGING_STATE:
			return LinkJVM.get_create_battery_charging_state();
		case BATTERY_VOLTAGE:
			return LinkJVM.get_create_battery_voltage();
		case BATTERY_CURRENT:
			return LinkJVM.get_create_battery_current();
		case BATTERY_TEMP:
			return LinkJVM.get_create_battery_temp();
		case BATTERY_CHARGE:
			return LinkJVM.get_create_battery_charge();
		case BATTERY_CAPACITY:
			return LinkJVM.get_create_battery_capacity();
		case WALL_AMT:
			return LinkJVM.get_create_wall_amt();
		case LCLIFF_AMT:
			return LinkJVM.get_create_lcliff_amt();
		case LFCLIFF_AMT:
			return LinkJVM.get_create_lfcliff_amt();
		case RFCLIFF_AMT:
			return LinkJVM.get_create_rfcliff_amt();
		case RCLIFF_AMT:
			return LinkJVM.get_create_rcliff_amt();
		case BAY_DI:
			return LinkJVM.get_create_bay_DI();
		case BAY_AI:
			return LinkJVM.get_create_bay_AI();
		case SONG_NUMBER:
			return LinkJVM.get_create_song_number();
		case SONG_PLAYING:
			return LinkJVM.get_create_song_playing();
		case NUMBER_OF_STREAM_PACKETS:
			return LinkJVM.get_create_number_of_stream_packets();
		case REQUESTED_VELOCITY:
			return LinkJVM.get_create_requested_velocity();
		case REQUESTED_RADIUS:
			return LinkJVM.get_create_requested_radius();
		case REQUESTED_RIGHT_VELOCITY:
			return LinkJVM.get_create_requested__right_velocity();
		case REQUESTED_LEFT_VELOCITY:
			return LinkJVM.get_create_requested_left_velocity();
		default:
			return 0;
		}	
	}
	
	/**
	 * Sets the distance which is returned by {@code createInstance.get(DISTANCE)}.
	 * 
	 * @param dist distance
	 */
	public void setDistance(int dist){
		LinkJVM.set_create_distance(dist);
	}
	
	/**
	 * Sets the angle which is returned by {@code createInstance.get(NORMALIZED_ANGLE)}.
	 * 
	 * @param angle angle
	 */
	public void setNormalizedAngle(int angle){
		LinkJVM.set_create_normalized_angle(angle);
	}
	
	/**
	 * Sets the angle which is returned by {@code createInstance.get(TOTAL_ANGLE)}.
	 * 
	 * @param angle angle
	 */
	public void setTotalAngle(int angle){
		LinkJVM.set_create_total_angle(angle);
	}
	
	/**
	 * Disconnects the create.
	 */
	public void disconnect(){
		LinkJVM.create_disconnect();
	}
	
	/**
	 * Connects the KIPR Link to the create.
	 * 
	 * @return 0 on success and a negative number on failure
	 */
	public int connect(){
		return LinkJVM.create_connect();
	}
	
	/**
	 * Sets the create into the passive mode(no motors).
	 */
	public void passive(){
		LinkJVM.create_passive();
	}
	
	/**
	 * Create will execute all command until the drop or cliff fire. Then it will stop.
	 */
	public void safe(){
		LinkJVM.create_safe();
	}
	
	/**
	 * Create will to everything and never stop even if cliff or drop fire.
	 */
	public void full(){
		LinkJVM.create_full();
	}
	
	/**
	 * Simulates a Roomba doing a spot clean.
	 */
	public void spot(){
		LinkJVM.create_spot();
	}
	
	/**
	 * Simulates a Roomba covering a room.
	 */
	public void cover(){
		LinkJVM.create_cover();
	}
	
	/**
	 * Runs the demo.
	 * @param d
	 */
	public void demo(int d){
		LinkJVM.create_demo(d);
	}
	
	/**
	 * Create roams around until it sees an IR dock and then attmpts to dock
	 */
	public void coverDock(){
		LinkJVM.create_cover_dock();
	}
	
	/**
	 * Stop the motors.
	 */
	public void stop(){
		LinkJVM.create_stop();
	}
	
	/**
	 * Drives an arc.
	 * 
	 * @param speed speed from 20 to 500 mm/sec
	 * @param radius radius
	 */
	public void drive(int speed, int radius){
		LinkJVM.create_drive(speed, radius);
	}
	
	/**
	 * Drive straight at specified speed.
	 * 
	 * @param speed speed from -500 to 500
	 */
	public void driveStraight(int speed){
		LinkJVM.create_drive_straight(speed);
	}
	
	/**
	 * Spins clockwise at the specified speed.
	 * 
	 * @param speed speed
	 */
	public void spinCW(int speed){
		LinkJVM.create_spin_CW(speed);
	}
	
	/**
	 * Spins counterclockwise at the specified speed.
	 * 
	 * @param speed speed
	 */
	public void spinCCW(int speed){
		LinkJVM.create_spin_CCW(speed);
	}
	
	/**
	 * Sets the speed of every motor in mm per sec.
	 * 
	 * @param lSpeed left motors speed
	 * @param rSpeed right motors speed
	 */
	public void driveDirect(int lSpeed, int rSpeed){
		LinkJVM.create_drive_direct(rSpeed, lSpeed);
	}
	
	/**
	 * Turns the advanced led on or off.
	 * 
	 * @param on 1 for on or 0 for off
	 */
	public void advanceLed(int on){
		LinkJVM.create_advance_led(on);
	}
	
	/**
	 * Turns the play led on or off.
	 * 
	 * @param on 1 for on or 0 for off
	 */
	public void playLed(int on){
		LinkJVM.create_play_led(on);
	}
	
	/**
	 * Sets the power led«s brightness and color
	 * 
	 * @param color 0 for pure red to 255 for pure green
	 * @param brightness 0 off and 255 for full
	 */
	public void powerLed(int color, int brightness){
		LinkJVM.create_power_led(color, brightness);
	}
	
	/**
	 * Loads a song from the gc_song_array[16][33]. Each row is one song.
	 * 
	 * @param num number of song
	 */
	public void loadSong(int num){
		LinkJVM.create_load_song(num);
	}
	
	/**
	 * Plays any songs that have been loaded.
	 * 
	 * @param num number so song
	 */
	public void playSong(int num){
		LinkJVM.create_play_song(num);
	}
}
