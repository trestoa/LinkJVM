CMAKE_MINIMUM_REQUIRED(VERSION 2.8.2)
FIND_PACKAGE(Java)
INCLUDE(./cmake/UseJava.cmake)

PROJECT(LinkJVM Java C)

set(JAVA_SRC_DIR src/java)
set(JAVA_SRC
	${JAVA_SRC_DIR}/linkjvm/high/ardrone/command/*.java
	${JAVA_SRC_DIR}/linkjvm/high/ardrone/listeners/*.java
	${JAVA_SRC_DIR}/linkjvm/high/ardrone/manager/*.java
	${JAVA_SRC_DIR}/linkjvm/high/ardrone/navdata/javadrone/*.java
	${JAVA_SRC_DIR}/linkjvm/high/ardrone/navdata/*.java
	${JAVA_SRC_DIR}/linkjvm/high/ardrone/utils/*.java
	${JAVA_SRC_DIR}/linkjvm/high/ardrone/video/*.java
	${JAVA_SRC_DIR}/linkjvm/high/ardrone/*.java
	${JAVA_SRC_DIR}/linkjvm/high/create/*.java
	${JAVA_SRC_DIR}/linkjvm/high/motors/*.java
	${JAVA_SRC_DIR}/linkjvm/high/sensors/analog/acceleration/*.java
	${JAVA_SRC_DIR}/linkjvm/high/sensors/analog/*.java
	${JAVA_SRC_DIR}/linkjvm/high/sensors/buttons/*.java
	${JAVA_SRC_DIR}/linkjvm/high/sensors/digital/*.java
	${JAVA_SRC_DIR}/linkjvm/high/sensors/*.java
	${JAVA_SRC_DIR}/linkjvm/low/accel/*.java
	${JAVA_SRC_DIR}/linkjvm/low/analog/*.java
	${JAVA_SRC_DIR}/linkjvm/low/buttons/*.java
	${JAVA_SRC_DIR}/linkjvm/low/camera/*.java
	${JAVA_SRC_DIR}/linkjvm/low/create/*.java
	${JAVA_SRC_DIR}/linkjvm/low/datalog/*.java
	${JAVA_SRC_DIR}/linkjvm/low/factory/*.java
	${JAVA_SRC_DIR}/linkjvm/low/geom/*.java
	${JAVA_SRC_DIR}/linkjvm/low/motors/*.java
	${JAVA_SRC_DIR}/linkjvm/low/sensors/*.java
	${JAVA_SRC_DIR}/linkjvm/low/*.java	
)
set(JNI_DIR src/jni)
set(JAVAC_DIR java-environment/javac)
set(JAR_DIR java-environment/jar)
set(CMAKE_JAVA_COMPILE_FLAGS -source 6)
set(LIBRARY_OUTPUT_PATH ${CMAKE_SOURCE_DIR}/lib)
set(CMAKE_JAVA_TARGET_OUTPUT_DIR ${CMAKE_SOURCE_DIR}/lib)
set(EXECUTABLE_OUTPUT_PATH ${PROJECT_BINARY_DIR}/bin)

add_jar(linkjvm-java ${JAVA_SRC})

add_subdirectory(${JNI_DIR})
add_subdirectory(${JAVAC_DIR})
add_subdirectory(${JAR_DIR})
