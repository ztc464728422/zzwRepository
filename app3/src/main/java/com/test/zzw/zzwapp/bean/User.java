package com.test.zzw.zzwapp.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;


/**
 * Created by zzw on 2017/6/1.
 */

public class User {
    private final String firstName;
    private final String lastName;
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
}