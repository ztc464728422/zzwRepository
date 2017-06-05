package com.test.zzw.zzwapp.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.test.zzw.zzwapp.R;
import com.test.zzw.zzwapp.activity.fragment.DataBindingFragment;
import com.test.zzw.zzwapp.activity.handler.EventHandlers;
import com.test.zzw.zzwapp.bean.Student;
import com.test.zzw.zzwapp.bean.TestObservableFieldBean;
import com.test.zzw.zzwapp.bean.User;
import com.test.zzw.zzwapp.databinding.ActivityDatabindingBinding;

import java.util.ArrayList;

/**
 * Created by zzw on 2017/6/1.
 */

public class DataBindingActivity extends AppCompatActivity {

    private Student mStu;
    private TestObservableFieldBean testObservableFieldBean;

    ObservableArrayList<String> list;
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
         list = new ObservableArrayList<>();
        list.add("loader!!!");
        binding.setList(list);

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_content,new DataBindingFragment()).commit();
    }

    public void myClick(View view) {
        mStu.setName("zzw——222");
        testObservableFieldBean.name.set("i am a pag2222");
        list.clear();
        list.add("loader!!!22222");
    }
}
