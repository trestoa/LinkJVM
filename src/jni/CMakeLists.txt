include_directories(${CMAKE_SOURCE_DIR}/java-environment/classpath/include)
add_library(linkjvmjni SHARED 
	buttons_wrap.cxx
	accel_wrap.cxx
	analog_wrap.cxx
	battery_wrap.cxx
	datalog_wrap.cxx
	vision_wrap.cxx
	console_wrap.cxx
	create_wrap.cxx
	ir_wrap.cxx
	digital_wrap.cxx
	motors_wrap.cxx
	sensors_wrap.cxx
	servo_wrap.cxx
)
SET_TARGET_PROPERTIES(linkjvmjni PROPERTIES LINKER_LANGUAGE C)
target_link_libraries(linkjvmjni libkovan.so)
