package com.test.zzw.zzwapp.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.test.zzw.zzwapp.Api;
import com.test.zzw.zzwapp.R;
import com.test.zzw.zzwapp.databinding.ActivityDatabindingBinding;
import com.test.zzw.zzwapp.databinding.ActivityRxjavaBinding;
import com.test.zzw.zzwapp.httpentity.LoginResponse;
import com.test.zzw.zzwapp.httprovider.RetrofitProvider;

import org.json.JSONObject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;


/**
 * Created by Administrator on 2017/6/6.
 */

public class RxJavaTestActivity extends AppCompatActivity {
    final static String TAG = "RxJavaTestActivity";
    Context mContext ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRxjavaBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_rxjava);
        binding.setAcitvity(this);
        mContext = RxJavaTestActivity.this;
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                Log.d(TAG, "Observable thread is : " + Thread.currentThread().getName());
//                emitter.onNext(1);
//                emitter.onNext(2);
//                emitter.onComplete();
//                emitter.onNext(3);
//            }
//        }).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "Observer thread is :" + Thread.currentThread().getName());
//            }
//
//            @Override
//            public void onNext(Integer value) {
//                Log.d(TAG, "" + value + "--thread=" + Thread.currentThread().getName());
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "error");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "complete");
//            }
//        });

    }



    public static void practice1(final Context context) {
        Api api = RetrofitProvider.get().create(Api.class);
        api.getVersion().subscribeOn(Schedulers.io())               //在IO线程进行网络请求
                .observeOn(AndroidSchedulers.mainThread())  //回到主线程去处理请求结果
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(String value) {
                        Log.e(TAG, "onNext: "+value );

                        //再使用Retrofit自带的JSON解析（或者别的什么）
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(context, "登录失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(context, "登录成功", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void myClick(View v){
        practice1(mContext);
    }
}
