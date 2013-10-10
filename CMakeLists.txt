CMAKE_MINIMUM_REQUIRED(VERSION 2.8.2)
FIND_PACKAGE(Java)
INCLUDE(UseJava)

PROJECT(LinkJVM Java)

set(JAVA_SRC_DIR src/java)
set(JAVA_SRC
	${JAVA_SRC_DIR}/linkjvm/ardrone/*.java
	${JAVA_SRC_DIR}/linkjvm/ardrone/command/*.java
	${JAVA_SRC_DIR}/linkjvm/ardrone/listeners/*.java
	${JAVA_SRC_DIR}/linkjvm/ardrone/manager/*.java
	${JAVA_SRC_DIR}/linkjvm/ardrone/navdata/*.java
	${JAVA_SRC_DIR}/linkjvm/ardrone/navdata/javadrone/*.java
	${JAVA_SRC_DIR}/linkjvm/ardrone/utils/*.java
	${JAVA_SRC_DIR}/linkjvm/libkovan/*.java
	${JAVA_SRC_DIR}/linkjvm/libkovan/jni/*.java
	${JAVA_SRC_DIR}/linkjvm/events/*.java
)
set(JNI_SRC_DIR src/jni)

add_jar(linkjvm ${JAVA_SRC})

include_directories(${JNI_SRC_DIR}/include)
add_library(linkjvm libkovan_wrap.c)
target_link_libraries(linkjvm libkovan)
