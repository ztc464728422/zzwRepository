#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_test_zzw_zzwapp_jni_JNIUtils2_fromJni(JNIEnv *env, jclass type) {

    // TODO


    return (*env)->NewStringUTF(env, "fromzzwjni.c");
}

JNIEXPORT jstring JNICALL
Java_com_test_zzw_zzwapp_jni_JNIUtils2_fromJni22222(JNIEnv *env, jclass type) {

    // TODO


    return (*env)->NewStringUTF(env, "fromzzwjni.c");
}

