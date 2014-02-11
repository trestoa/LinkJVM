CMAKE_MINIMUM_REQUIRED(VERSION 2.8.2)
FIND_PACKAGE(Java)
INCLUDE(./cmake/UseJava.cmake)

PROJECT(LinkJVM Java C CXX)

set(JAVA_SRC_DIR src/java)
set(JAVA_SRC
	${JAVA_SRC_DIR}/linkjvm/*.java
	${JAVA_SRC_DIR}/linkjvm/ardrone/command/*.java
	${JAVA_SRC_DIR}/linkjvm/ardrone/listeners/*.java
	${JAVA_SRC_DIR}/linkjvm/ardrone/manager/*.java
	${JAVA_SRC_DIR}/linkjvm/ardrone/navdata/javadrone/*.java
	${JAVA_SRC_DIR}/linkjvm/ardrone/navdata/*.java
	${JAVA_SRC_DIR}/linkjvm/ardrone/utils/*.java
	${JAVA_SRC_DIR}/linkjvm/ardrone/video/*.java
	${JAVA_SRC_DIR}/linkjvm/ardrone/*.java
	${JAVA_SRC_DIR}/linkjvm/create/*.java
	${JAVA_SRC_DIR}/linkjvm/debugger/*.java
	${JAVA_SRC_DIR}/linkjvm/motors/*.java
	${JAVA_SRC_DIR}/linkjvm/sensors/analog/acceleration/*.java
	${JAVA_SRC_DIR}/linkjvm/sensors/analog/*.java
	${JAVA_SRC_DIR}/linkjvm/sensors/buttons/*.java
	${JAVA_SRC_DIR}/linkjvm/sensors/digital/*.java
	${JAVA_SRC_DIR}/linkjvm/sensors/*.java
	${JAVA_SRC_DIR}/linkjvm/vision/depth/*.java
	${JAVA_SRC_DIR}/linkjvm/vision/*.java
	${JAVA_SRC_DIR}/linkjvm/low/accel/*.java
	${JAVA_SRC_DIR}/linkjvm/low/analog/*.java
	${JAVA_SRC_DIR}/linkjvm/low/buttons/*.java
	${JAVA_SRC_DIR}/linkjvm/low/create/*.java
	${JAVA_SRC_DIR}/linkjvm/low/datalog/*.java
	${JAVA_SRC_DIR}/linkjvm/low/factory/*.java
	${JAVA_SRC_DIR}/linkjvm/low/motors/*.java
	${JAVA_SRC_DIR}/linkjvm/low/sensors/*.java
	${JAVA_SRC_DIR}/linkjvm/low/vision/*.java
	${JAVA_SRC_DIR}/linkjvm/low/*.java
)
set(JNI_DIR src/jni)
set(TOOLS_DIR tools)
set(JAVAC_DIR java-environment/javac)
set(JAR_DIR java-environment/jar)
set(CMAKE_JAVA_COMPILE_FLAGS -source 6)
set(LIBRARY_OUTPUT_PATH ${CMAKE_SOURCE_DIR}/lib)
set(CMAKE_JAVA_TARGET_OUTPUT_DIR ${CMAKE_SOURCE_DIR}/lib)
set(EXECUTABLE_OUTPUT_PATH ${PROJECT_BINARY_DIR}/bin)

add_jar(linkjvmjava ${JAVA_SRC})

add_subdirectory(${JNI_DIR})
add_subdirectory(${JAVAC_DIR})
add_subdirectory(${JAR_DIR})
add_subdirectory(${TOOLS_DIR}/kar-gen)
