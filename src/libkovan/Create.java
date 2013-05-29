package libkovan;

import libkovan.jni.Libkovan;


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

	public Create(){
		Libkovan.create_connect();
	}
	
	public void start(){
		Libkovan.create_start();
	}
	
	public int get(int val){
		switch(val){
		case MODE:
			return Libkovan.get_create_mode();
		case LBUMP:
			return Libkovan.get_create_lbump();
		case RBUMP:
			return Libkovan.get_create_rbump();
		case LWDROP:
			return Libkovan.get_create_lwdrop();
		case CWDROP:
			return Libkovan.get_create_cwdrop();
		case RWDROP:
			return Libkovan.get_create_rwdrop();
		case WALL:
			return Libkovan.get_create_wall();
		case LCLIFF:
			return Libkovan.get_create_lcliff();
		case LFCLIFF:
			return Libkovan.get_create_lfcliff();
		case RFCLIFF:
			return Libkovan.get_create_rfcliff();
		case RCLIFF:
			return Libkovan.get_create_rcliff();
		case VWALL:
			return Libkovan.get_create_vwall();
		case OVERCURRENTS:
			return Libkovan.get_create_overcurrents();
		case INFRARED:
			return Libkovan.get_create_infrared();
		case ADVANCE_BUTTON:
			return Libkovan.get_create_advance_button();
		case PLAY_BUTTON:
			return Libkovan.get_create_play_button();
		case NORMALIZED_ANGLE:
			return Libkovan.get_create_normalized_angle();
		case TOTAL_ANGLE:
			return Libkovan.get_create_total_angle();
		case DISTANCE:
			return Libkovan.get_create_distance();
		case BATTERY_CHARGING_STATE:
			return Libkovan.get_create_battery_charging_state();
		case BATTERY_VOLTAGE:
			return Libkovan.get_create_battery_voltage();
		case BATTERY_CURRENT:
			return Libkovan.get_create_battery_current();
		case BATTERY_TEMP:
			return Libkovan.get_create_battery_temp();
		case BATTERY_CHARGE:
			return Libkovan.get_create_battery_charge();
		case BATTERY_CAPACITY:
			return Libkovan.get_create_battery_capacity();
		case WALL_AMT:
			return Libkovan.get_create_wall_amt();
		case LCLIFF_AMT:
			return Libkovan.get_create_lcliff_amt();
		case LFCLIFF_AMT:
			return Libkovan.get_create_lfcliff_amt();
		case RFCLIFF_AMT:
			return Libkovan.get_create_rfcliff_amt();
		case RCLIFF_AMT:
			return Libkovan.get_create_rcliff_amt();
		case BAY_DI:
			return Libkovan.get_create_bay_DI();
		case BAY_AI:
			return Libkovan.get_create_bay_AI();
		case SONG_NUMBER:
			return Libkovan.get_create_song_number();
		case SONG_PLAYING:
			return Libkovan.get_create_song_playing();
		case NUMBER_OF_STREAM_PACKETS:
			return Libkovan.get_create_number_of_stream_packets();
		case REQUESTED_VELOCITY:
			return Libkovan.get_create_requested_velocity();
		case REQUESTED_RADIUS:
			return Libkovan.get_create_requested_radius();
		case REQUESTED_RIGHT_VELOCITY:
			return Libkovan.get_create_requested__right_velocity();
		case REQUESTED_LEFT_VELOCITY:
			return Libkovan.get_create_requested_left_velocity();
		default:
			return 0;
		}	
	}
	
	public void setDistance(int dist){
		Libkovan.set_create_distance(dist);
	}
	
	public void setNormalizedAngle(int angle){
		Libkovan.set_create_normalized_angle(angle);
	}
	
	public void setTotalAngle(int angle){
		Libkovan.set_create_total_angle(angle);
	}
	
	public void disconnect(){
		Libkovan.create_disconnect();
	}
	
	public int connect(){
		return Libkovan.create_connect();
	}
	
	public void passive(){
		Libkovan.create_passive();
	}
	
	public void safe(){
		Libkovan.create_safe();
	}
	
	public void full(){
		Libkovan.create_full();
	}
	
	public void spot(){
		Libkovan.create_spot();
	}
	
	public void cover(){
		Libkovan.create_cover();
	}
	
	public void demo(int d){
		Libkovan.create_demo(d);
	}
	
	public void coverDock(){
		Libkovan.create_cover_dock();
	}
	
	public void stop(){
		Libkovan.create_stop();
	}
	
	public void drive(int speed, int radius){
		Libkovan.create_drive(speed, radius);
	}
	
	public void driveStraight(int speed){
		Libkovan.create_drive_straight(speed);
	}
	
	public void spinCW(int speed){
		Libkovan.create_spin_CW(speed);
	}
	
	public void spinCCW(int speed){
		Libkovan.create_spin_CCW(speed);
	}
	
	public void driveDirect(int lSpeed, int rSpeed){
		Libkovan.create_drive_direct(rSpeed, lSpeed);
	}
	
	public void advanceLed(int on){
		Libkovan.create_advance_led(on);
	}
	
	public void playLed(int on){
		Libkovan.create_play_led(on);
	}
	
	public void powerLed(int color, int brightness){
		Libkovan.create_power_led(color, brightness);
	}
	
	public void loadSong(int num){
		Libkovan.create_load_song(num);
	}
	
	public void playSong(int num){
		Libkovan.create_play_song(num);
	}
}
