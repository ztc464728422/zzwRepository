package com.test.zzw.zzwapp.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/6/8.
 */

public class ResultHttp<T> {
    int code;
    T EntityObject;
    List<T> Data;
    String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getEntityObject() {
        return EntityObject;
    }

    public void setEntityObject(T entityObject) {
        EntityObject = entityObject;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return Data;
    }

    public void setData(List<T> data) {
        Data = data;
    }
}
