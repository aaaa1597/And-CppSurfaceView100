cmake_minimum_required(VERSION 3.4.1)

add_library( testlib SHARED src/main/cpp/CppSurfaceView.cpp )

find_library( log-lib log )

target_link_libraries( testlib ${log-lib} android EGL GLESv2 m )
