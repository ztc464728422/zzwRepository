package com.test.zzw.zzwapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.test.zzw.zzwapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zzw on 2017/4/19.
 */

public class TestActivity extends MyBaseAppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_btns_tvs);

        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.btn_b1,R.id.btn_b2,R.id. btn_b3,R.id. btn_b4,R.id. btn_b5})
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_b1:
                Toast.makeText(mContext,HelloLoad(),Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_b2:
//                Toast.makeText(mContext,HelloLoad(),Toast.LENGTH_LONG).show();
                thistest();
                break;
            case R.id. btn_b3:
                testoperator();
                break;
            case R.id. btn_b4:
                cThread();
            case R.id. btn_b5:
                cThread2();
                break;
        }
    }



    public native String HelloLoad();
    public native void thistest();
    public native  void testoperator();
    public native  void cThread();
    public native void cThread2();
    public native String HelloLoadPar(int k,String str);
    static {
        System.loadLibrary("zzwjni");  // 加载本地libndk_load.so库文件
    }

}
