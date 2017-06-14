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
import com.test.zzw.zzwapp.bean.LinkUser;
import com.test.zzw.zzwapp.bean.ResultHttp;
import com.test.zzw.zzwapp.bean.Version;
import com.test.zzw.zzwapp.databinding.ActivityDatabindingBinding;
import com.test.zzw.zzwapp.databinding.ActivityRxjavaBinding;
import com.test.zzw.zzwapp.http.RequestImpl;
import com.test.zzw.zzwapp.httpentity.LoginResponse;
import com.test.zzw.zzwapp.httprovider.RetrofitProvider;
import com.test.zzw.zzwapp.model.UserOperModel;
import com.test.zzw.zzwapp.utils.StringUtils;

import org.json.JSONObject;
import org.reactivestreams.Subscription;

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
    private Context mContext ;
    private UserOperModel userOperModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRxjavaBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_rxjava);
        binding.setAcitvity(this);
        mContext = RxJavaTestActivity.this;
        userOperModel = new UserOperModel();
        userOperModel.setData("135671428365","ztc123");
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
                .subscribe(new Observer<ResultHttp<Version>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ResultHttp<Version> value) {
                        Log.e(TAG, "onNext: "+value.getCode() );
                        if(value.getCode() == 0){
                            Version v = value.getEntityObject();
                            Toast.makeText(context,v.getVersionDesp(),Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(context, "获取版本失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(context, "获取版本成功", Toast.LENGTH_SHORT).show();
                    }
                });
    }



    public void myClick(View v){
        switch (v.getId()){
            case R.id.btn_version:
                practice1(mContext);
                break;
            case R.id.btn_login:
                doLogin(mContext);
                break;
        }
    }
    public void doLogin(final Context context) {
        userOperModel.doLogin(context, new RequestImpl() {
            @Override
            public void loadSuccess(Object object) {
                if(object == null) return;
                ResultHttp<LinkUser> re = (ResultHttp<LinkUser>)object;
                if(re.getEntityObject()!=null ){
                    Toast.makeText(context,re.getEntityObject().getNickname(),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,"登录失败"+re.getMsg(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void loadFailed() {
                Toast.makeText(context,"无法获取信息",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void addSubscription(Subscription subscription) {

            }
        });
    }

}
