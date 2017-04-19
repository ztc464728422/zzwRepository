package com.test.zzw.zzwapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.test.zzw.zzwapp.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by zzw on 2017/4/19.
 */

public class TestAdActivity extends AppCompatActivity {

    @InjectView(R.id.list_test)
    ListView listTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.inject(this);
    }
}
