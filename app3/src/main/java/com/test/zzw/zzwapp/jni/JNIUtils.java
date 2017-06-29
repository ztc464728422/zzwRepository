package com.test.zzw.zzwapp.jni;

/**
 * Created by zzw on 2017/5/12.
 */

public class JNIUtils {
    static {
        System.loadLibrary("zzwjni");
    }
    public native static String fromJni();
    public native static String fromJni2();
    public native static String fromVectortest();
}
