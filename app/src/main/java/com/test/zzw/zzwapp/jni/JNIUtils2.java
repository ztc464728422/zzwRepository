package com.test.zzw.zzwapp.jni;

/**
 * Created by zzw on 2017/5/12.
 */

public class JNIUtils2 {
    static {
        System.loadLibrary("zzwjni");
    }
    public native static String fromJni();
    public native  static String fromJni22222();

}
