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
import butterknife.BindView;

/**
 * Created by zzw on 2017/4/19.
 */

public class TestAdActivity extends AppCompatActivity {

    @BindView(R.id.list_test)
    ListView listTest;

    private ArrayList<PersonBean> personBeenList ;
    private MyBaseAdapter<PersonBean> personBeanMyBaseAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        initAdapter();
    }

    private void initAdapter() {
        personBeenList = new ArrayList<>();
        for(int i = 0 ; i< 10 ; i++){
            PersonBean personBean = new PersonBean();
            personBean.setName("name"+i);
            personBean.setAddr("addr"+i);
            personBeenList.add(personBean);
        }
        personBeanMyBaseAdapter = new MyBaseAdapter<PersonBean>(personBeenList,R.layout.adapter_item) {
            @Override
            public void bindView(ViewHolder holder, final PersonBean obj) {
                holder.setText(R.id.tv_t1,obj.getName());
                holder.setText(R.id.tv_t2,obj.getAddr());
                holder.setOnClickListener(R.id.tv_t2, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(TestAdActivity.this,obj.getName(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        listTest.setAdapter(personBeanMyBaseAdapter);
    }

}
