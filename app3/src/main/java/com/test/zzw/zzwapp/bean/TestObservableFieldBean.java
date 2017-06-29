package com.test.zzw.zzwapp.bean;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * Created by zzw on 2017/6/1.
 */

public class TestObservableFieldBean {
    public ObservableField<String> name = new ObservableField<>();
    public ObservableInt age = new ObservableInt();
    public ObservableBoolean isMan = new ObservableBoolean();
}
