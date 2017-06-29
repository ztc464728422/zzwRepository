package com.test.zzw.zzwapp.bean;

/**
 * Created by zzw on 2017/4/19.
 */

public class PersonBean {
    private int id;
    private String name;
    private String addr;

    public PersonBean() {
    }

    public PersonBean(String name, String addr) {
        this.name = name;
        this.addr = addr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
