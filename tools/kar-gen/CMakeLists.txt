include_directories(qt4/QtCore qt4)
add_executable(kar-gen kar-gen.cpp)
target_link_libraries(kar-gen libkar.so ${QT_LIBRARIES})
