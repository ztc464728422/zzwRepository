package com.test.zzw.zzwapp.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.test.zzw.zzwapp.BR;

/**
 * Created by zzw on 2017/6/1.
 */

public class Student extends BaseObservable {
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}