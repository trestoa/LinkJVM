find_package(Qt4 REQUIRED)

set(QT_DONT_USE_QTGUI TRUE)

include(${QT_USE_FILE})

add_executable(kar-gen kar-gen.cpp)
target_link_libraries(kar-gen libkar.so ${QT_LIBRARIES})
