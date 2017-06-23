cmake_minimum_required(VERSION 3.4.1)

add_library(zzwjni SHARED src/jni/zzwjni.c src/jni/myjni.c)

find_library(log-lib log)

target_link_libraries(zzwjni
                    ${log-lib}
                      android
                      atomic
                      log
                      OpenSLES)