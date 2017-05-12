#include <jni.h>
#include <stdio.h>
#include <unistd.h>
#include <android/log.h>

#define LOG_TAG "Edwin"
#define LOGD(...) __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

JNIEXPORT void JNICALL
Java_com_test_zzw_zzwapp_activity_MainActivity_helloJni(JNIEnv *env, jobject instance) {

    // TODO

}

JNIEXPORT jstring JNICALL
Java_com_test_zzw_zzwapp_activity_MainActivity_fromJni(JNIEnv *env, jobject instance) {


    return (*env)->NewStringUTF(env, "NDK 来自于C文件");
}

JNIEXPORT jstring JNICALL
Java_com_test_zzw_zzwapp_activity_MainActivity_fromJni2(JNIEnv *env, jobject instance) {

    // TODO


    return (*env)->NewStringUTF(env, "2");
}

JNIEXPORT void JNICALL
Java_com_test_zzw_zzwapp_activity_MainActivity_helloJni2(JNIEnv *env, jobject instance) {

    int code = fork();
    if (code > 0) {
        //父进程
        LOGD("parent-->code=%d\n", code);
    } else if (code == 0) {
        //子进程
        LOGD("children-->code=%d\n", code);
        int stop = 1;

        while (stop) {
            //每隔1秒钟判断应用目录是否存在
            sleep(1);
            LOGD("sleep-->code=%d\n", code);
            FILE *file = fopen("/data/data/com.test.zzw.zzwapp", "r");
            if (file == NULL) {

                LOGD("uninstall-->code=%d\n", code);
                //TODO 通过Linux命令启动浏览器问卷调查...删除文件等等操作
                execlp("am", "am", "start", "-a", "android.intent.action.VIEW", "-d",
                       "http://wuhaoyou.com/wp/", NULL);
                stop = 0;
            }
        }
    } else {
        //其它
        LOGD("error-->code=%d\n", code);
    }

}

JNIEXPORT jstring JNICALL
Java_com_test_zzw_zzwapp_jni_JNIUtils_fromJni(JNIEnv *env, jclass type) {

    // TODO


    return (*env)->NewStringUTF(env, "来自于JNIUtils.java");
}

JNIEXPORT jstring JNICALL
Java_com_test_zzw_zzwapp_jni_JNIUtils_fromJni2(JNIEnv *env, jobject instance) {

    // TODO


    return (*env)->NewStringUTF(env, "来自于JNIUtils");
}