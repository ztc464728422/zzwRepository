package com.test.zzw.zzwapp.activity.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.zzw.zzwapp.R;
import com.test.zzw.zzwapp.adapter.DatabindingRecAdapter;
import com.test.zzw.zzwapp.bean.Student;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/6/5.
 */

public class DataBindingFragment extends Fragment {

    com.test.zzw.zzwapp.Custom binding;

    private Student mStu;
    private ArrayList<Student> mData = new ArrayList<Student>() {
        {
            for (int i=0;i<10;i++) add(new Student("loader" + i));
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,
                R.layout.frag_databinding, container, false);
        mStu = new Student("loader");
        binding.setStu2(mStu);
        binding.setFrag(this);
        binding.setImageUrl("http://g.hiphotos.baidu.com/baike/w%3D268%3Bg%3D0/sign=f78b3af03bdbb6fd255be220311fcc25/c75c10385343fbf214402828b27eca8065388f49.jpg");
//        mRecyclerView = (RecyclerView) binding.getRoot().findViewById(R.id.recyclerview);

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        binding.recyclerview.setAdapter(new DatabindingRecAdapter(mData));
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void click(View view) {
        mStu.setName("qibin");

    }
}
