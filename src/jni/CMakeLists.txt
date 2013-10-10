SET_TARGET_PROPERTIES(linkjvm-jni PROPERTIES LINKER_LANGUAGE C)
add_library(linkjvm-jni libkovan_wrap.c)
target_link_libraries(linkjvm-jni libkovan)