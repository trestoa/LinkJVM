add_library(linkjvm-jni ${JNI_SRC_DIR}/libkovan_wrap.c)
target_link_libraries(linkjvm-jni libkovan)