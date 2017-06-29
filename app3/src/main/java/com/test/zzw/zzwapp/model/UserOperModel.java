package com.test.zzw.zzwapp.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.test.zzw.zzwapp.Api;
import com.test.zzw.zzwapp.bean.LinkUser;
import com.test.zzw.zzwapp.bean.ResultHttp;
import com.test.zzw.zzwapp.http.RequestImpl;
import com.test.zzw.zzwapp.httprovider.RetrofitProvider;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/6/8.
 */

public class UserOperModel {
    private static final String TAG = "UserOperModel";
    private String phone;
    private String password;

    public void setData(String phone,String password){
        this.password = password;
        this.phone = phone;
    }

    public void doLogin( final Context context,final RequestImpl listener){
        Api api = RetrofitProvider.get().create(Api.class);
        api.login(phone,password).subscribeOn(Schedulers.io())               //在IO线程进行网络请求
                .observeOn(AndroidSchedulers.mainThread())  //回到主线程去处理请求结果
                .subscribe(new Observer<ResultHttp<LinkUser>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ResultHttp<LinkUser> value) {
//                        Log.e(TAG, "onNext: "+value.getCode() );
//                        if(value.getCode() == 0){
//                            LinkUser v = value.getEntityObject();
////                            Toast.makeText(context,v.getNickname(),Toast.LENGTH_SHORT).show();
//                        }
                        listener.loadSuccess(value);

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.loadFailed();
//                        Toast.makeText(context, "登录失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
//                        Toast.makeText(context, "登录成功", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
