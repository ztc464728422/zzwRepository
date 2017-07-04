package com.test.zzw.zzwapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.test.zzw.zzwapp.R;
import com.test.zzw.zzwapp.adapter.MyBaseAdapter;
import com.test.zzw.zzwapp.bean.PersonBean;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by zzw on 2017/4/19.
 */

public class modelActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
    }

}
