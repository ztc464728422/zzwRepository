package com.test.zzw.zzwapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

        ButterKnife.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick(R.id.btn_b1)
    public void onClick() {
        Toast.makeText(mContext,HelloLoad(),Toast.LENGTH_LONG).show();
    }

    public native String HelloLoad();
    public native String HelloLoadPar(int k,String str);
    static {
        System.loadLibrary("zzwjni");  // 加载本地libndk_load.so库文件
    }

}
