add_library(linkjvm-jni SHARED libkovan_wrap.c)
SET_TARGET_PROPERTIES(linkjvm-jni PROPERTIES LINKER_LANGUAGE C)
target_link_libraries(linkjvm-jni libkovan)