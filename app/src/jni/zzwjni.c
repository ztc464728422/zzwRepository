#include <jni.h>
#include <vector.h>
const int seq_size = 18;
int elem_vals[seq_size]  = {1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8,3,4};
vector<int> elem_seq{elem_vals,elem_vals+seq_size};

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

JNIEXPORT jstring JNICALL
Java_com_test_zzw_zzwapp_activity_TestActivity_HelloLoad(JNIEnv *env, jobject instance) {

    // TODO


    return (*env)->NewStringUTF(env, "zzw");
}

JNIEXPORT jstring JNICALL
Java_com_test_zzw_zzwapp_activity_TestActivity_HelloLoadPar(JNIEnv *env, jobject instance, jint k,
                                                            jstring str_) {
    const char *str = (*env)->GetStringUTFChars(env, str_, 0);

    // TODO


    (*env)->ReleaseStringUTFChars(env, str_, str);

    return (*env)->NewStringUTF(env, str_);
}