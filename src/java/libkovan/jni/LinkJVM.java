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
* IMPORTANT!!!
* Do not make changes to this file unless you know what you are doing--modify
* the SWIG interface file instead.
*/



package libkovan.jni;

public class LinkJVM {
  public static int drone_connect() {
    return LinkJVMJNI.drone_connect();
  }

  public static void drone_disconnect() {
    LinkJVMJNI.drone_disconnect();
  }

  public static void drone_calibrate() {
    LinkJVMJNI.drone_calibrate();
  }

  public static int get_drone_version() {
    return LinkJVMJNI.get_drone_version();
  }

  public static void drone_takeoff() {
    LinkJVMJNI.drone_takeoff();
  }

  public static void drone_land() {
    LinkJVMJNI.drone_land();
  }

  public static int get_drone_battery() {
    return LinkJVMJNI.get_drone_battery();
  }

  public static void drone_clear_position() {
    LinkJVMJNI.drone_clear_position();
  }

  public static float get_drone_x() {
    return LinkJVMJNI.get_drone_x();
  }

  public static float get_drone_y() {
    return LinkJVMJNI.get_drone_y();
  }

  public static float get_drone_z() {
    return LinkJVMJNI.get_drone_z();
  }

  public static float get_drone_x_velocity() {
    return LinkJVMJNI.get_drone_x_velocity();
  }

  public static float get_drone_y_velocity() {
    return LinkJVMJNI.get_drone_y_velocity();
  }

  public static float get_drone_z_velocity() {
    return LinkJVMJNI.get_drone_z_velocity();
  }

  public static float get_drone_pitch() {
    return LinkJVMJNI.get_drone_pitch();
  }

  public static float get_drone_roll() {
    return LinkJVMJNI.get_drone_roll();
  }

  public static float get_drone_altitude() {
    return LinkJVMJNI.get_drone_altitude();
  }

  public static float get_drone_yaw() {
    return LinkJVMJNI.get_drone_yaw();
  }

  public static int drone_camera_open(drone_camera camera) {
    return LinkJVMJNI.drone_camera_open(camera.swigValue());
  }

  public static int set_drone_mac_address(String address) {
    return LinkJVMJNI.set_drone_mac_address(address);
  }

  public static int drone_pair() {
    return LinkJVMJNI.drone_pair();
  }

  public static int set_drone_ssid(String ssid) {
    return LinkJVMJNI.set_drone_ssid(ssid);
  }

  public static void drone_move(float x_tilt, float y_tilt, float z_vel, float yaw_vel) {
    LinkJVMJNI.drone_move(x_tilt, y_tilt, z_vel, yaw_vel);
  }

  public static void drone_hover() {
    LinkJVMJNI.drone_hover();
  }

  public static void set_drone_emergency_stop_enabled(int enabled) {
    LinkJVMJNI.set_drone_emergency_stop_enabled(enabled);
  }

  public static int get_drone_emergency_stop_enabled() {
    return LinkJVMJNI.get_drone_emergency_stop_enabled();
  }

  public static void beep() {
    LinkJVMJNI.beep();
  }

  public static int get_motor_position_counter(int motor) {
    return LinkJVMJNI.get_motor_position_counter(motor);
  }

  public static void clear_motor_position_counter(int motor) {
    LinkJVMJNI.clear_motor_position_counter(motor);
  }

  public static int move_at_velocity(int motor, int velocity) {
    return LinkJVMJNI.move_at_velocity(motor, velocity);
  }

  public static int mav(int motor, int velocity) {
    return LinkJVMJNI.mav(motor, velocity);
  }

  public static int move_to_position(int motor, int speed, int goal_pos) {
    return LinkJVMJNI.move_to_position(motor, speed, goal_pos);
  }

  public static int mtp(int motor, int speed, int goal_pos) {
    return LinkJVMJNI.mtp(motor, speed, goal_pos);
  }

  public static int move_relative_position(int motor, int speed, int delta_pos) {
    return LinkJVMJNI.move_relative_position(motor, speed, delta_pos);
  }

  public static int mrp(int motor, int speed, int delta_pos) {
    return LinkJVMJNI.mrp(motor, speed, delta_pos);
  }

  public static void set_pid_gains(int motor, short p, short i, short d, short pd, short id, short dd) {
    LinkJVMJNI.set_pid_gains(motor, p, i, d, pd, id, dd);
  }

  public static void get_pid_gains(int motor, SWIGTYPE_p_short p, SWIGTYPE_p_short i, SWIGTYPE_p_short d, SWIGTYPE_p_short pd, SWIGTYPE_p_short id, SWIGTYPE_p_short dd) {
    LinkJVMJNI.get_pid_gains(motor, SWIGTYPE_p_short.getCPtr(p), SWIGTYPE_p_short.getCPtr(i), SWIGTYPE_p_short.getCPtr(d), SWIGTYPE_p_short.getCPtr(pd), SWIGTYPE_p_short.getCPtr(id), SWIGTYPE_p_short.getCPtr(dd));
  }

  public static int freeze(int motor) {
    return LinkJVMJNI.freeze(motor);
  }

  public static int get_motor_done(int motor) {
    return LinkJVMJNI.get_motor_done(motor);
  }

  public static void block_motor_done(int motor) {
    LinkJVMJNI.block_motor_done(motor);
  }

  public static void bmd(int motor) {
    LinkJVMJNI.bmd(motor);
  }

  public static int setpwm(int motor, int pwm) {
    return LinkJVMJNI.setpwm(motor, pwm);
  }

  public static int getpwm(int motor) {
    return LinkJVMJNI.getpwm(motor);
  }

  public static void fd(int motor) {
    LinkJVMJNI.fd(motor);
  }

  public static void bk(int motor) {
    LinkJVMJNI.bk(motor);
  }

  public static void motor(int motor, int percent) {
    LinkJVMJNI.motor(motor, percent);
  }

  public static void off(int motor) {
    LinkJVMJNI.off(motor);
  }

  public static void alloff() {
    LinkJVMJNI.alloff();
  }

  public static void ao() {
    LinkJVMJNI.ao();
  }

  public static void enable_servo(int port) {
    LinkJVMJNI.enable_servo(port);
  }

  public static void disable_servo(int port) {
    LinkJVMJNI.disable_servo(port);
  }

  public static void enable_servos() {
    LinkJVMJNI.enable_servos();
  }

  public static void disable_servos() {
    LinkJVMJNI.disable_servos();
  }

  public static void set_servo_enabled(int port, int enabled) {
    LinkJVMJNI.set_servo_enabled(port, enabled);
  }

  public static int get_servo_enabled(int port) {
    return LinkJVMJNI.get_servo_enabled(port);
  }

  public static int get_servo_position(int servo) {
    return LinkJVMJNI.get_servo_position(servo);
  }

  public static void set_servo_position(int servo, int position) {
    LinkJVMJNI.set_servo_position(servo, position);
  }

  public static void set_a_button_text(String text) {
    LinkJVMJNI.set_a_button_text(text);
  }

  public static void set_b_button_text(String text) {
    LinkJVMJNI.set_b_button_text(text);
  }

  public static void set_c_button_text(String text) {
    LinkJVMJNI.set_c_button_text(text);
  }

  public static void set_x_button_text(String text) {
    LinkJVMJNI.set_x_button_text(text);
  }

  public static void set_y_button_text(String text) {
    LinkJVMJNI.set_y_button_text(text);
  }

  public static void set_z_button_text(String text) {
    LinkJVMJNI.set_z_button_text(text);
  }

  public static int a_button() {
    return LinkJVMJNI.a_button();
  }

  public static int b_button() {
    return LinkJVMJNI.b_button();
  }

  public static int c_button() {
    return LinkJVMJNI.c_button();
  }

  public static int x_button() {
    return LinkJVMJNI.x_button();
  }

  public static int y_button() {
    return LinkJVMJNI.y_button();
  }

  public static int z_button() {
    return LinkJVMJNI.z_button();
  }

  public static int side_button() {
    return LinkJVMJNI.side_button();
  }

  public static int black_button() {
    return LinkJVMJNI.black_button();
  }

  public static int a_button_clicked() {
    return LinkJVMJNI.a_button_clicked();
  }

  public static int b_button_clicked() {
    return LinkJVMJNI.b_button_clicked();
  }

  public static int c_button_clicked() {
    return LinkJVMJNI.c_button_clicked();
  }

  public static int x_button_clicked() {
    return LinkJVMJNI.x_button_clicked();
  }

  public static int y_button_clicked() {
    return LinkJVMJNI.y_button_clicked();
  }

  public static int z_button_clicked() {
    return LinkJVMJNI.z_button_clicked();
  }

  public static int side_button_clicked() {
    return LinkJVMJNI.side_button_clicked();
  }

  public static int any_button() {
    return LinkJVMJNI.any_button();
  }

  public static void extra_buttons_show() {
    LinkJVMJNI.extra_buttons_show();
  }

  public static void extra_buttons_hide() {
    LinkJVMJNI.extra_buttons_hide();
  }

  public static int get_extra_buttons_visible() {
    return LinkJVMJNI.get_extra_buttons_visible();
  }

  public static void set_extra_buttons_visible(int visible) {
    LinkJVMJNI.set_extra_buttons_visible(visible);
  }

  public static int digital(int port) {
    return LinkJVMJNI.digital(port);
  }

  public static void set_digital_value(int port, int value) {
    LinkJVMJNI.set_digital_value(port, value);
  }

  public static int get_digital_value(int port) {
    return LinkJVMJNI.get_digital_value(port);
  }

  public static void set_digital_output(int port, int out) {
    LinkJVMJNI.set_digital_output(port, out);
  }

  public static int get_digital_output(int port) {
    return LinkJVMJNI.get_digital_output(port);
  }

  public static int get_digital_pullup(int port) {
    return LinkJVMJNI.get_digital_pullup(port);
  }

  public static void set_digital_pullup(int port, int pullup) {
    LinkJVMJNI.set_digital_pullup(port, pullup);
  }

  public static int camera_open(Resolution res) {
    return LinkJVMJNI.camera_open(res.swigValue());
  }

  public static int camera_open_device(int number, Resolution res) {
    return LinkJVMJNI.camera_open_device(number, res.swigValue());
  }

  public static int camera_load_config(String name) {
    return LinkJVMJNI.camera_load_config(name);
  }

  public static void set_camera_width(int width) {
    LinkJVMJNI.set_camera_width(width);
  }

  public static void set_camera_height(int height) {
    LinkJVMJNI.set_camera_height(height);
  }

  public static int get_camera_width() {
    return LinkJVMJNI.get_camera_width();
  }

  public static int get_camera_height() {
    return LinkJVMJNI.get_camera_height();
  }

  public static int camera_update() {
    return LinkJVMJNI.camera_update();
  }

  public static pixel get_camera_pixel(point2 p) {
    return new pixel(LinkJVMJNI.get_camera_pixel(point2.getCPtr(p), p), true);
  }

  public static int get_channel_count() {
    return LinkJVMJNI.get_channel_count();
  }

  public static int get_object_count(int channel) {
    return LinkJVMJNI.get_object_count(channel);
  }

  public static String get_object_data(int channel, int object) {
    return LinkJVMJNI.get_object_data(channel, object);
  }

  public static int get_code_num(int channel, int object) {
    return LinkJVMJNI.get_code_num(channel, object);
  }

  public static int get_object_data_length(int channel, int object) {
    return LinkJVMJNI.get_object_data_length(channel, object);
  }

  public static double get_object_confidence(int channel, int object) {
    return LinkJVMJNI.get_object_confidence(channel, object);
  }

  public static int get_object_area(int channel, int object) {
    return LinkJVMJNI.get_object_area(channel, object);
  }

  public static rectangle get_object_bbox(int channel, int object) {
    return new rectangle(LinkJVMJNI.get_object_bbox(channel, object), true);
  }

  public static point2 get_object_centroid(int channel, int object) {
    return new point2(LinkJVMJNI.get_object_centroid(channel, object), true);
  }

  public static point2 get_object_center(int channel, int object) {
    return new point2(LinkJVMJNI.get_object_center(channel, object), true);
  }

  public static void camera_close() {
    LinkJVMJNI.camera_close();
  }

  public static point2 create_point2(int x, int y) {
    return new point2(LinkJVMJNI.create_point2(x, y), true);
  }

  public static rectangle create_rectangle(int ulx, int uly, int width, int height) {
    return new rectangle(LinkJVMJNI.create_rectangle(ulx, uly, width, height), true);
  }

  public static short accel_x() {
    return LinkJVMJNI.accel_x();
  }

  public static short accel_y() {
    return LinkJVMJNI.accel_y();
  }

  public static short accel_z() {
    return LinkJVMJNI.accel_z();
  }

  public static int accel_calibrate() {
    return LinkJVMJNI.accel_calibrate();
  }

  public static int analog10(int port) {
    return LinkJVMJNI.analog10(port);
  }

  public static int analog(int port) {
    return LinkJVMJNI.analog(port);
  }

  public static void set_analog_pullup(int port, int pullup) {
    LinkJVMJNI.set_analog_pullup(port, pullup);
  }

  public static int get_analog_pullup(int port) {
    return LinkJVMJNI.get_analog_pullup(port);
  }

  public static int battery_charging() {
    return LinkJVMJNI.battery_charging();
  }

  public static float power_level() {
    return LinkJVMJNI.power_level();
  }

  public static void shut_down_in(double s) {
    LinkJVMJNI.shut_down_in(s);
  }

  public static void wait_for_light(int light_port_) {
    LinkJVMJNI.wait_for_light(light_port_);
  }

  public static void console_clear() {
    LinkJVMJNI.console_clear();
  }

  public static int create_connect() {
    return LinkJVMJNI.create_connect();
  }

  public static void create_disconnect() {
    LinkJVMJNI.create_disconnect();
  }

  public static void create_start() {
    LinkJVMJNI.create_start();
  }

  public static void create_passive() {
    LinkJVMJNI.create_passive();
  }

  public static void create_safe() {
    LinkJVMJNI.create_safe();
  }

  public static void create_full() {
    LinkJVMJNI.create_full();
  }

  public static void create_spot() {
    LinkJVMJNI.create_spot();
  }

  public static void create_cover() {
    LinkJVMJNI.create_cover();
  }

  public static void create_demo(int d) {
    LinkJVMJNI.create_demo(d);
  }

  public static void create_cover_dock() {
    LinkJVMJNI.create_cover_dock();
  }

  public static int get_create_mode() {
    return LinkJVMJNI.get_create_mode();
  }

  public static int get_create_lbump() {
    return LinkJVMJNI.get_create_lbump();
  }

  public static int get_create_rbump() {
    return LinkJVMJNI.get_create_rbump();
  }

  public static int get_create_lwdrop() {
    return LinkJVMJNI.get_create_lwdrop();
  }

  public static int get_create_cwdrop() {
    return LinkJVMJNI.get_create_cwdrop();
  }

  public static int get_create_rwdrop() {
    return LinkJVMJNI.get_create_rwdrop();
  }

  public static int get_create_wall() {
    return LinkJVMJNI.get_create_wall();
  }

  public static int get_create_lcliff() {
    return LinkJVMJNI.get_create_lcliff();
  }

  public static int get_create_lfcliff() {
    return LinkJVMJNI.get_create_lfcliff();
  }

  public static int get_create_rfcliff() {
    return LinkJVMJNI.get_create_rfcliff();
  }

  public static int get_create_rcliff() {
    return LinkJVMJNI.get_create_rcliff();
  }

  public static int get_create_vwall() {
    return LinkJVMJNI.get_create_vwall();
  }

  public static int get_create_overcurrents() {
    return LinkJVMJNI.get_create_overcurrents();
  }

  public static int get_create_infrared() {
    return LinkJVMJNI.get_create_infrared();
  }

  public static int get_create_advance_button() {
    return LinkJVMJNI.get_create_advance_button();
  }

  public static int get_create_play_button() {
    return LinkJVMJNI.get_create_play_button();
  }

  public static int get_create_normalized_angle() {
    return LinkJVMJNI.get_create_normalized_angle();
  }

  public static void set_create_normalized_angle(int angle) {
    LinkJVMJNI.set_create_normalized_angle(angle);
  }

  public static int get_create_total_angle() {
    return LinkJVMJNI.get_create_total_angle();
  }

  public static void set_create_total_angle(int angle) {
    LinkJVMJNI.set_create_total_angle(angle);
  }

  public static int get_create_distance() {
    return LinkJVMJNI.get_create_distance();
  }

  public static void set_create_distance(int dist) {
    LinkJVMJNI.set_create_distance(dist);
  }

  public static int get_create_battery_charging_state() {
    return LinkJVMJNI.get_create_battery_charging_state();
  }

  public static int get_create_battery_voltage() {
    return LinkJVMJNI.get_create_battery_voltage();
  }

  public static int get_create_battery_current() {
    return LinkJVMJNI.get_create_battery_current();
  }

  public static int get_create_battery_temp() {
    return LinkJVMJNI.get_create_battery_temp();
  }

  public static int get_create_battery_charge() {
    return LinkJVMJNI.get_create_battery_charge();
  }

  public static int get_create_battery_capacity() {
    return LinkJVMJNI.get_create_battery_capacity();
  }

  public static int get_create_wall_amt() {
    return LinkJVMJNI.get_create_wall_amt();
  }

  public static int get_create_lcliff_amt() {
    return LinkJVMJNI.get_create_lcliff_amt();
  }

  public static int get_create_lfcliff_amt() {
    return LinkJVMJNI.get_create_lfcliff_amt();
  }

  public static int get_create_rfcliff_amt() {
    return LinkJVMJNI.get_create_rfcliff_amt();
  }

  public static int get_create_rcliff_amt() {
    return LinkJVMJNI.get_create_rcliff_amt();
  }

  public static int get_create_bay_DI() {
    return LinkJVMJNI.get_create_bay_DI();
  }

  public static int get_create_bay_AI() {
    return LinkJVMJNI.get_create_bay_AI();
  }

  public static int get_create_song_number() {
    return LinkJVMJNI.get_create_song_number();
  }

  public static int get_create_song_playing() {
    return LinkJVMJNI.get_create_song_playing();
  }

  public static int get_create_number_of_stream_packets() {
    return LinkJVMJNI.get_create_number_of_stream_packets();
  }

  public static int get_create_requested_velocity() {
    return LinkJVMJNI.get_create_requested_velocity();
  }

  public static int get_create_requested_radius() {
    return LinkJVMJNI.get_create_requested_radius();
  }

  public static int get_create_requested__right_velocity() {
    return LinkJVMJNI.get_create_requested__right_velocity();
  }

  public static int get_create_requested_left_velocity() {
    return LinkJVMJNI.get_create_requested_left_velocity();
  }

  public static void create_stop() {
    LinkJVMJNI.create_stop();
  }

  public static void create_drive(int speed, int radius) {
    LinkJVMJNI.create_drive(speed, radius);
  }

  public static void create_drive_straight(int speed) {
    LinkJVMJNI.create_drive_straight(speed);
  }

  public static void create_spin_CW(int speed) {
    LinkJVMJNI.create_spin_CW(speed);
  }

  public static void create_spin_CCW(int speed) {
    LinkJVMJNI.create_spin_CCW(speed);
  }

  public static void create_drive_direct(int r_speed, int l_speed) {
    LinkJVMJNI.create_drive_direct(r_speed, l_speed);
  }

  public static void create_advance_led(int on) {
    LinkJVMJNI.create_advance_led(on);
  }

  public static void create_play_led(int on) {
    LinkJVMJNI.create_play_led(on);
  }

  public static void create_power_led(int color, int brightness) {
    LinkJVMJNI.create_power_led(color, brightness);
  }

  public static void create_load_song(int num) {
    LinkJVMJNI.create_load_song(num);
  }

  public static void create_play_song(int num) {
    LinkJVMJNI.create_play_song(num);
  }

  public static void datalog_remove_category(String name) {
    LinkJVMJNI.datalog_remove_category(name);
  }

  public static void datalog_append_string(String text, String category) {
    LinkJVMJNI.datalog_append_string(text, category);
  }

  public static void datalog_append_number(double number, String category) {
    LinkJVMJNI.datalog_append_number(number, category);
  }

  public static void datalog_remove(int index, String category) {
    LinkJVMJNI.datalog_remove(index, category);
  }

  public static int datalog_write_plain(String path) {
    return LinkJVMJNI.datalog_write_plain(path);
  }

  public static int datalog_write_csv(String path) {
    return LinkJVMJNI.datalog_write_csv(path);
  }

  public static void datalog_clear() {
    LinkJVMJNI.datalog_clear();
  }

  public static void debug_print_registers() {
    LinkJVMJNI.debug_print_registers();
  }

  public static int register_value(int addy) {
    return LinkJVMJNI.register_value(addy);
  }

  public static int debug_dump_data(SWIGTYPE_p_unsigned_char data, long size, String where) {
    return LinkJVMJNI.debug_dump_data(SWIGTYPE_p_unsigned_char.getCPtr(data), size, where);
  }

  public static void display_clear() {
    LinkJVMJNI.display_clear();
  }

  public static void display_printf(int col, int row, String t) {
    LinkJVMJNI.display_printf(col, row, t);
  }

  public static int draw_open() {
    return LinkJVMJNI.draw_open();
  }

  public static void draw_point(int x, int y) {
    LinkJVMJNI.draw_point(x, y);
  }

  public static void draw_line(int sx, int sy, int ex, int ey) {
    LinkJVMJNI.draw_line(sx, sy, ex, ey);
  }

  public static void draw_clear() {
    LinkJVMJNI.draw_clear();
  }

  public static void draw_close() {
    LinkJVMJNI.draw_close();
  }

  public static void set_auto_publish(int on) {
    LinkJVMJNI.set_auto_publish(on);
  }

  public static void publish() {
    LinkJVMJNI.publish();
  }

  public static void halt() {
    LinkJVMJNI.halt();
  }

  public static void freeze_halt() {
    LinkJVMJNI.freeze_halt();
  }

  public static void ir_read() {
    LinkJVMJNI.ir_read();
  }

  public static void ir_write() {
    LinkJVMJNI.ir_write();
  }

  public static void msleep(int msecs) {
    LinkJVMJNI.msleep(msecs);
  }

  public static long systime() {
    return LinkJVMJNI.systime();
  }

  public static double seconds() {
    return LinkJVMJNI.seconds();
  }

}
