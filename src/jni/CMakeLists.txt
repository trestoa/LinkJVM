include_directories(${CMAKE_SOURCE_DIR}/java-environment/classpath/include)
add_library(linkjvm-jni SHARED libkovan_wrap.c)
SET_TARGET_PROPERTIES(linkjvm-jni PROPERTIES LINKER_LANGUAGE C)
target_link_libraries(linkjvm-jni libkovan.so)