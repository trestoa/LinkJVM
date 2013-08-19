/*
* This file is part of LinkJVM.
*
* Java Framework for the KIPR Link
* Copyright (C) 2013 Markus Klein <m@mklein.co.at>
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

%module LinkJVM
%{
#include "include/kovan/kovan.h"
%}
/* ardrone.h */
int drone_connect();
void drone_disconnect();
void drone_calibrate();
int get_drone_version();
void drone_takeoff();
void drone_land();
int get_drone_battery(void);
void drone_clear_position();
float get_drone_x(void);
float get_drone_y(void);
float get_drone_z(void);
float get_drone_x_velocity(void);
float get_drone_y_velocity(void);
float get_drone_z_velocity(void);
float get_drone_pitch(void);
float get_drone_roll(void);
float get_drone_altitude(void);
float get_drone_yaw(void);
enum drone_camera
{
FRONT_CAMERA,
BOTTOM_CAMERA
};
int drone_camera_open(enum drone_camera camera);
int set_drone_mac_address(const char *const address);
int drone_pair(void);
int set_drone_ssid(const char *const ssid);
void drone_move(float x_tilt, float y_tilt, float z_vel, float yaw_vel);
void drone_hover(void);
void set_drone_emergency_stop_enabled(int enabled);
int get_drone_emergency_stop_enabled(void);

/* audio.h */
void beep(void);

/* motors.h */
int get_motor_position_counter(int motor);
void clear_motor_position_counter(int motor);
int move_at_velocity(int motor, int velocity);
int mav(int motor, int velocity);
int move_to_position(int motor, int speed, int goal_pos);
int mtp(int motor, int speed, int goal_pos);
int move_relative_position(int motor, int speed, int delta_pos);
int mrp(int motor, int speed, int delta_pos);
void set_pid_gains(int motor, short p, short i, short d, short pd, short id, short dd);
void get_pid_gains(int motor, short *p, short *i, short *d, short *pd, short *id, short *dd);
int freeze(int motor);
int get_motor_done(int motor);
void block_motor_done(int motor);
void bmd(int motor);
int setpwm(int motor, int pwm);
int getpwm(int motor);
void fd(int motor);
void bk(int motor);
void motor(int motor, int percent);
void off(int motor);
void alloff();
void ao();

/* servo.h */
void enable_servo(int port);
void disable_servo(int port);
void enable_servos();
void disable_servos();
void set_servo_enabled(int port, int enabled);
int get_servo_enabled(int port);
int get_servo_position(int servo);
void set_servo_position(int servo, int position);

/* button.h */
void set_a_button_text(const char *text);
void set_b_button_text(const char *text);
void set_c_button_text(const char *text);
void set_x_button_text(const char *text);
void set_y_button_text(const char *text);
void set_z_button_text(const char *text);
int a_button();
int b_button();
int c_button();
int x_button();
int y_button();
int z_button();
int side_button();
int black_button();
int a_button_clicked();
int b_button_clicked();
int c_button_clicked();
int x_button_clicked();
int y_button_clicked();
int z_button_clicked();
int side_button_clicked();
int any_button();
void extra_buttons_show();
void extra_buttons_hide();
int get_extra_buttons_visible();
void set_extra_buttons_visible(int visible);

/* digital.h */
int digital(int port);
void set_digital_value(int port, int value);
int get_digital_value(int port);
void set_digital_output(int port, int out);
int get_digital_output(int port);
int get_digital_pullup(int port);
void set_digital_pullup(int port, int pullup);

/* camera.h */
typedef struct pixel
{
int r;
int g;
int b;
} pixel;
enum Resolution
{
LOW_RES,
MED_RES,
HIGH_RES
};
int camera_open(enum Resolution res);
int camera_open_device(int number, enum Resolution res);
int camera_load_config(const char *name);
void set_camera_width(int width);
void set_camera_height(int height);
int get_camera_width(void);
int get_camera_height(void);
int camera_update(void);
pixel get_camera_pixel(point2 p);
int get_channel_count(void);
int get_object_count(int channel);
const char *get_object_data(int channel, int object);
int get_code_num(int channel, int object);
int get_object_data_length(int channel, int object);
double get_object_confidence(int channel, int object);
int get_object_area(int channel, int object);
rectangle get_object_bbox(int channel, int object);
point2 get_object_centroid(int channel, int object);
point2 get_object_center(int channel, int object);
void camera_close();

/* geom.h */
typedef struct point2
{
int x;
int y;
} point2;
typedef struct rectangle
{
int ulx;
int uly;
int width;
int height;
} rectangle;
point2 create_point2(int x, int y);
rectangle create_rectangle(int ulx, int uly, int width, int height);

/* accel.h */
short accel_x();
short accel_y();
short accel_z();
int accel_calibrate();

/* analog.h */
int analog10(int port);
int analog(int port);
void set_analog_pullup(int port, int pullup);
int get_analog_pullup(int port);

/* battery.h */
int battery_charging();
float power_level();

/* botball.h */
void shut_down_in(double s);
void wait_for_light(int light_port_);

/* console.h */
void console_clear();

/* create.h */
int create_connect();
void create_disconnect();
void create_start();
void create_passive();
void create_safe();
void create_full();
void create_spot();
void create_cover();
void create_demo(int d);
void create_cover_dock();
int get_create_mode();
int get_create_lbump();
int get_create_rbump();
int get_create_lwdrop();
int get_create_cwdrop();
int get_create_rwdrop();
int get_create_wall();
int get_create_lcliff();
int get_create_lfcliff();
int get_create_rfcliff();
int get_create_rcliff();
int get_create_vwall();
int get_create_overcurrents();
int get_create_infrared();
int get_create_advance_button();
int get_create_play_button();
int get_create_normalized_angle();
void set_create_normalized_angle(int angle);
int get_create_total_angle();
void set_create_total_angle(int angle);
int get_create_distance();
void set_create_distance(int dist);
int get_create_battery_charging_state();
int get_create_battery_voltage();
int get_create_battery_current();
int get_create_battery_temp();
int get_create_battery_charge();
int get_create_battery_capacity();
int get_create_wall_amt();
int get_create_lcliff_amt();
int get_create_lfcliff_amt();
int get_create_rfcliff_amt();
int get_create_rcliff_amt();
int get_create_bay_DI();
int get_create_bay_AI();
int get_create_song_number();
int get_create_song_playing();
int get_create_number_of_stream_packets();
int get_create_requested_velocity();
int get_create_requested_radius();
int get_create_requested__right_velocity();
int get_create_requested_left_velocity();
void create_stop();
void create_drive(int speed, int radius);
void create_drive_straight(int speed);
void create_spin_CW(int speed);
void create_spin_CCW(int speed);
void create_drive_direct(int r_speed, int l_speed);
void create_advance_led(int on);
void create_play_led(int on);
void create_power_led(int color, int brightness);
void create_load_song(int num);
void create_play_song(int num);

/* datalog.h */
void datalog_remove_category(const char *name);
void datalog_append_string(const char *text, const char *category);
void datalog_append_number(double number, const char *category);
void datalog_remove(int index, const char *category);
int datalog_write_plain(const char *path);
int datalog_write_csv(const char *path);
void datalog_clear();

/* debug.h */
void debug_print_registers();
unsigned short register_value(unsigned short addy);
int debug_dump_data(const unsigned char *const data, const size_t size, const char *const where);

/* display.h */
void display_clear();
void display_printf(int col, int row, const char *t, ...);

/* draw.h */
int draw_open();
void draw_point(int x, int y);
void draw_line(int sx, int sy, int ex, int ey);
void draw_clear();
void draw_close();

/* general.h */
void set_auto_publish(int on);
void publish();
void halt();
void freeze_halt();

/* ir.h */
void ir_read();
void ir_write();

/* util.h */
void msleep(long msecs);
unsigned long systime();
double seconds();