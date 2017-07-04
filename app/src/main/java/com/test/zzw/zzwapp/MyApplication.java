package com.test.zzw.zzwapp;

import android.app.Application;

import com.test.zzw.zzwapp.utils.ImageLoaderUtils;

/**
 * Created by Administrator on 2017/6/5.
 */

public class MyApplication extends SampleApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderUtils.initConfiguration(getApplicationContext());
    }
}
