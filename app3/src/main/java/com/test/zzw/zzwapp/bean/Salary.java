package com.test.zzw.zzwapp.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zzw on 2017/5/2.
 */

public class Salary implements Parcelable {
    private String type;
    private Integer salary;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeValue(this.salary);
    }

    public Salary() {
    }

    public Salary(String type, Integer salary) {
        this.type = type;
        this.salary = salary;
    }

    protected Salary(Parcel in) {
        this.type = in.readString();
        this.salary = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<Salary> CREATOR = new Creator<Salary>() {
        @Override
        public Salary createFromParcel(Parcel source) {
            return new Salary(source);
        }

        @Override
        public Salary[] newArray(int size) {
            return new Salary[size];
        }
    };

    public String toString() {
        return "工作:" + type + "    薪水: " + salary;
    }
}
