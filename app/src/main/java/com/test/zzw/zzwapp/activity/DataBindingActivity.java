package com.test.zzw.zzwapp.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.test.zzw.zzwapp.R;
import com.test.zzw.zzwapp.activity.handler.EventHandlers;
import com.test.zzw.zzwapp.bean.Student;
import com.test.zzw.zzwapp.bean.TestObservableFieldBean;
import com.test.zzw.zzwapp.bean.User;
import com.test.zzw.zzwapp.databinding.ActivityDatabindingBinding;

/**
 * Created by zzw on 2017/6/1.
 */

public class DataBindingActivity extends AppCompatActivity {

    private Student mStu;
    private TestObservableFieldBean testObservableFieldBean;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDatabindingBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        User user = new User("Test", "User");
        binding.setUser(user);
        binding.setHandlers(new EventHandlers());
        mStu = new Student("zzw");
        binding.setStu(mStu);
        binding.setClick(this);
        testObservableFieldBean = new TestObservableFieldBean();
        binding.setTestObservableFieldBean(testObservableFieldBean);
        testObservableFieldBean.name.set("i am a pag");
    }

    public void myClick(View view) {
        mStu.setName("zzw——222");
        testObservableFieldBean.name.set("i am a pag2222");


    }
}
