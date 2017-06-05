package com.test.zzw.zzwapp.activity.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.zzw.zzwapp.R;
import com.test.zzw.zzwapp.bean.Student;

/**
 * Created by Administrator on 2017/6/5.
 */

public class DataBindingFragment extends Fragment {
    private Student mStu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        com.test.zzw.zzwapp.Custom binding = DataBindingUtil.inflate(inflater,
                R.layout.frag_databinding, container, false);
        mStu = new Student("loader");
        binding.setStu(mStu);
        binding.setFrag(this);
        return binding.getRoot();
    }

    public void click(View view) {
        mStu.setName("qibin");
    }
}
