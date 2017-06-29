package com.test.zzw.zzwapp.bean;

/**
 * Created by zzw on 2017/4/19.
 */

public class App {
    private int id;
    private int icon;
    private String addr;

    public App() {
    }

    public App(int icon, String addr) {
        this.icon = icon;
        this.addr = addr;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
