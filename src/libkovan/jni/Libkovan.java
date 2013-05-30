/*
* This file is part of Libkovan Java.
*
* Java Framework for the KIPR Link
* Copyright (C) 2013 Markus Klein
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

package libkovan.jni;

/**
 * This class is only a wrapper an should not be used!
 */

public class Libkovan {
  public static void shut_down_in(double delay) {
    LibkovanJNI.shut_down_in(delay);
  }

  public static void wait_for_light(int light_port_) {
    LibkovanJNI.wait_for_light(light_port_);
  }

  public static int create_connect() {
    return LibkovanJNI.create_connect();
  }

  public static void create_disconnect() {
    LibkovanJNI.create_disconnect();
  }

  public static void create_start() {
    LibkovanJNI.create_start();
  }

  public static void create_passive() {
    LibkovanJNI.create_passive();
  }

  public static void create_safe() {
    LibkovanJNI.create_safe();
  }

  public static void create_full() {
    LibkovanJNI.create_full();
  }

  public static void create_spot() {
    LibkovanJNI.create_spot();
  }

  public static void create_cover() {
    LibkovanJNI.create_cover();
  }

  public static void create_demo(int d) {
    LibkovanJNI.create_demo(d);
  }

  public static void create_cover_dock() {
    LibkovanJNI.create_cover_dock();
  }

  public static int get_create_mode() {
    return LibkovanJNI.get_create_mode();
  }

  public static int get_create_lbump() {
    return LibkovanJNI.get_create_lbump();
  }

  public static int get_create_rbump() {
    return LibkovanJNI.get_create_rbump();
  }

  public static int get_create_lwdrop() {
    return LibkovanJNI.get_create_lwdrop();
  }

  public static int get_create_cwdrop() {
    return LibkovanJNI.get_create_cwdrop();
  }

  public static int get_create_rwdrop() {
    return LibkovanJNI.get_create_rwdrop();
  }

  public static int get_create_wall() {
    return LibkovanJNI.get_create_wall();
  }

  public static int get_create_lcliff() {
    return LibkovanJNI.get_create_lcliff();
  }

  public static int get_create_lfcliff() {
    return LibkovanJNI.get_create_lfcliff();
  }

  public static int get_create_rfcliff() {
    return LibkovanJNI.get_create_rfcliff();
  }

  public static int get_create_rcliff() {
    return LibkovanJNI.get_create_rcliff();
  }

  public static int get_create_vwall() {
    return LibkovanJNI.get_create_vwall();
  }

  public static int get_create_overcurrents() {
    return LibkovanJNI.get_create_overcurrents();
  }

  public static int get_create_infrared() {
    return LibkovanJNI.get_create_infrared();
  }

  public static int get_create_advance_button() {
    return LibkovanJNI.get_create_advance_button();
  }

  public static int get_create_play_button() {
    return LibkovanJNI.get_create_play_button();
  }

  public static int get_create_normalized_angle() {
    return LibkovanJNI.get_create_normalized_angle();
  }

  public static void set_create_normalized_angle(int angle) {
    LibkovanJNI.set_create_normalized_angle(angle);
  }

  public static int get_create_total_angle() {
    return LibkovanJNI.get_create_total_angle();
  }

  public static void set_create_total_angle(int angle) {
    LibkovanJNI.set_create_total_angle(angle);
  }

  public static int get_create_distance() {
    return LibkovanJNI.get_create_distance();
  }

  public static void set_create_distance(int dist) {
    LibkovanJNI.set_create_distance(dist);
  }

  public static int get_create_battery_charging_state() {
    return LibkovanJNI.get_create_battery_charging_state();
  }

  public static int get_create_battery_voltage() {
    return LibkovanJNI.get_create_battery_voltage();
  }

  public static int get_create_battery_current() {
    return LibkovanJNI.get_create_battery_current();
  }

  public static int get_create_battery_temp() {
    return LibkovanJNI.get_create_battery_temp();
  }

  public static int get_create_battery_charge() {
    return LibkovanJNI.get_create_battery_charge();
  }

  public static int get_create_battery_capacity() {
    return LibkovanJNI.get_create_battery_capacity();
  }

  public static int get_create_wall_amt() {
    return LibkovanJNI.get_create_wall_amt();
  }

  public static int get_create_lcliff_amt() {
    return LibkovanJNI.get_create_lcliff_amt();
  }

  public static int get_create_lfcliff_amt() {
    return LibkovanJNI.get_create_lfcliff_amt();
  }

  public static int get_create_rfcliff_amt() {
    return LibkovanJNI.get_create_rfcliff_amt();
  }

  public static int get_create_rcliff_amt() {
    return LibkovanJNI.get_create_rcliff_amt();
  }

  public static int get_create_bay_DI() {
    return LibkovanJNI.get_create_bay_DI();
  }

  public static int get_create_bay_AI() {
    return LibkovanJNI.get_create_bay_AI();
  }

  public static int get_create_song_number() {
    return LibkovanJNI.get_create_song_number();
  }

  public static int get_create_song_playing() {
    return LibkovanJNI.get_create_song_playing();
  }

  public static int get_create_number_of_stream_packets() {
    return LibkovanJNI.get_create_number_of_stream_packets();
  }

  public static int get_create_requested_velocity() {
    return LibkovanJNI.get_create_requested_velocity();
  }

  public static int get_create_requested_radius() {
    return LibkovanJNI.get_create_requested_radius();
  }

  public static int get_create_requested__right_velocity() {
    return LibkovanJNI.get_create_requested__right_velocity();
  }

  public static int get_create_requested_left_velocity() {
    return LibkovanJNI.get_create_requested_left_velocity();
  }

  public static void create_stop() {
    LibkovanJNI.create_stop();
  }

  public static void create_drive(int speed, int radius) {
    LibkovanJNI.create_drive(speed, radius);
  }

  public static void create_drive_straight(int speed) {
    LibkovanJNI.create_drive_straight(speed);
  }

  public static void create_spin_CW(int speed) {
    LibkovanJNI.create_spin_CW(speed);
  }

  public static void create_spin_CCW(int speed) {
    LibkovanJNI.create_spin_CCW(speed);
  }

  public static void create_drive_direct(int r_speed, int l_speed) {
    LibkovanJNI.create_drive_direct(r_speed, l_speed);
  }

  public static void create_advance_led(int on) {
    LibkovanJNI.create_advance_led(on);
  }

  public static void create_play_led(int on) {
    LibkovanJNI.create_play_led(on);
  }

  public static void create_power_led(int color, int brightness) {
    LibkovanJNI.create_power_led(color, brightness);
  }

  public static void create_load_song(int num) {
    LibkovanJNI.create_load_song(num);
  }

  public static void create_play_song(int num) {
    LibkovanJNI.create_play_song(num);
  }

  public static void alloff() {
    LibkovanJNI.alloff();
  }

  public static void ao() {
    LibkovanJNI.ao();
  }

  public static void bk(int m) {
    LibkovanJNI.bk(m);
  }

  public static void block_motor_done(int m) {
    LibkovanJNI.block_motor_done(m);
  }

  public static void bmd(int m) {
    LibkovanJNI.bmd(m);
  }

  public static void clear_motor_position_counter(int motor_nbr) {
    LibkovanJNI.clear_motor_position_counter(motor_nbr);
  }

  public static void fd(int m) {
    LibkovanJNI.fd(m);
  }

  public static void freeze(int m) {
    LibkovanJNI.freeze(m);
  }

  public static int get_motor_done(int m) {
    return LibkovanJNI.get_motor_done(m);
  }

  public static int get_motor_position_counter(int m) {
    return LibkovanJNI.get_motor_position_counter(m);
  }

  public static void mav(int m, int vel) {
    LibkovanJNI.mav(m, vel);
  }

  public static void motor(int m, int p) {
    LibkovanJNI.motor(m, p);
  }

  public static void move_at_velocity(int m, int vel) {
    LibkovanJNI.move_at_velocity(m, vel);
  }

  public static void move_relative_position(int m, int speed, int pos) {
    LibkovanJNI.move_relative_position(m, speed, pos);
  }

  public static void move_to_position(int m, int speed, int pos) {
    LibkovanJNI.move_to_position(m, speed, pos);
  }

  public static void mrp(int m, int vel, int pos) {
    LibkovanJNI.mrp(m, vel, pos);
  }

  public static void mtp(int m, int vel, int pos) {
    LibkovanJNI.mtp(m, vel, pos);
  }

  public static void off(int m) {
    LibkovanJNI.off(m);
  }

  public static void set_pid_gains(int motor, int p, int i, int d, int pd, int id, int dd) {
    LibkovanJNI.set_pid_gains(motor, p, i, d, pd, id, dd);
  }

  public static int setpwm(int m, int dutycycle) {
    return LibkovanJNI.setpwm(m, dutycycle);
  }

  public static void beep() {
    LibkovanJNI.beep();
  }

  public static void display_clear() {
    LibkovanJNI.display_clear();
  }

  public static void display_printf(int col, int row, String s) {
    LibkovanJNI.display_printf(col, row, s);
  }

  public static void printf(String s) {
    LibkovanJNI.printf(s);
  }

  public static void set_digital_output(int port, int inout) {
    LibkovanJNI.set_digital_output(port, inout);
  }

  public static void set_digital_value(int port, int value) {
    LibkovanJNI.set_digital_value(port, value);
  }

  public static int a_button() {
    return LibkovanJNI.a_button();
  }

  public static int analog(int p) {
    return LibkovanJNI.analog(p);
  }

  public static int analog10(int p) {
    return LibkovanJNI.analog10(p);
  }

  public static int b_button() {
    return LibkovanJNI.b_button();
  }

  public static int side_button() {
    return LibkovanJNI.side_button();
  }

  public static int digital(int p) {
    return LibkovanJNI.digital(p);
  }

  public static double power_level() {
    return LibkovanJNI.power_level();
  }

  public static void set_each_analog_state(int a0, int a1, int a2, int a3, int a4, int a5, int a6, int a7) {
    LibkovanJNI.set_each_analog_state(a0, a1, a2, a3, a4, a5, a6, a7);
  }

  public static void set_analog_pullup(int port, int pullupTF) {
    LibkovanJNI.set_analog_pullup(port, pullupTF);
  }

  public static void disable_servos() {
    LibkovanJNI.disable_servos();
  }

  public static void enable_servos() {
    LibkovanJNI.enable_servos();
  }

  public static int get_servo_position(int srv) {
    return LibkovanJNI.get_servo_position(srv);
  }

  public static void set_servo_position(int srv, int pos) {
    LibkovanJNI.set_servo_position(srv, pos);
  }

  public static void msleep(int msec) {
    LibkovanJNI.msleep(msec);
  }

  public static double seconds() {
    return LibkovanJNI.seconds();
  }

  public static void camera_close() {
    LibkovanJNI.camera_close();
  }

  public static int camera_load_config(String name) {
    return LibkovanJNI.camera_load_config(name);
  }

  public static int camera_open(int res_numb) {
    return LibkovanJNI.camera_open(res_numb);
  }

  public static int camera_open_device(int number) {
    return LibkovanJNI.camera_open_device(number);
  }

  public static int camera_update() {
    return LibkovanJNI.camera_update();
  }

  public static int get_channel_count() {
    return LibkovanJNI.get_channel_count();
  }

  public static int get_code_num(int channel, int object) {
    return LibkovanJNI.get_code_num(channel, object);
  }

  public static int get_object_area(int channel, int object) {
    return LibkovanJNI.get_object_area(channel, object);
  }

  public static double get_object_confidence(int channel, int object) {
    return LibkovanJNI.get_object_confidence(channel, object);
  }

  public static int get_object_count(int channel) {
    return LibkovanJNI.get_object_count(channel);
  }

  public static String get_object_data(int channel, int object) {
    return LibkovanJNI.get_object_data(channel, object);
  }

  public static int get_object_data_length(int channel, int object) {
    return LibkovanJNI.get_object_data_length(channel, object);
  }

}
