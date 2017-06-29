package com.test.zzw.zzwapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.test.zzw.zzwapp.R;
import com.test.zzw.zzwapp.adapter.MutiLayoutAdapter;
import com.test.zzw.zzwapp.adapter.MyBaseAdapter;
import com.test.zzw.zzwapp.bean.App;
import com.test.zzw.zzwapp.bean.Book;
import com.test.zzw.zzwapp.bean.PersonBean;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by zzw on 2017/4/19.
 */

public class MutiLayoutAdActivity extends AppCompatActivity {


        private static final int TYPE_BOOK = 0;
        private static final int TYPE_APP = 1;
        private ListView list_content;
        private ArrayList<Object> mData = null;
        private MutiLayoutAdapter myAdapter = null;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_test);

            //数据准备：
            mData = new ArrayList<Object>();
            for(int i = 0;i < 20;i++){
                switch (i/10){
                    case TYPE_BOOK:
                        mData.add(new Book("《第一行代码》","郭霖"));
                        break;
                    case TYPE_APP:
                        mData.add(new App(R.mipmap.ic_launcher,"百度"));
                        break;
                }
            }

            list_content = (ListView) findViewById(R.id.list_test);
            myAdapter = new MutiLayoutAdapter(MutiLayoutAdActivity.this,mData);
            list_content.setAdapter(myAdapter);
        }
}
