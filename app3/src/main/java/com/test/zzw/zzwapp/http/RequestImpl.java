package com.test.zzw.zzwapp.http;


import org.reactivestreams.Subscription;

/**
 * Created by jingbin on 2017/1/17.
 * 用于数据请求的回调
 */

public interface RequestImpl {
    void loadSuccess(Object object);

    void loadFailed();

    void addSubscription(Subscription subscription);
}
