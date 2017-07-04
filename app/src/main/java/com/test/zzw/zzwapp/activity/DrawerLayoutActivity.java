package com.test.zzw.zzwapp.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.test.zzw.zzwapp.R;
import com.test.zzw.zzwapp.activity.fragment.ContentFragment;
import com.test.zzw.zzwapp.adapter.MyBaseAdapter;
import com.test.zzw.zzwapp.bean.PersonBean;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.BindView;

/**
 * Created by zzw on 2017/4/19.
 */

public class DrawerLayoutActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {


    @BindView(R.id.ly_content)
    FrameLayout lyContent;
    @BindView(R.id.list_left_drawer)
    ListView listLeftDrawer;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    private ArrayList<PersonBean> menuLists;
    private MyBaseAdapter<PersonBean> myAdapter = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerlayout);
        ButterKnife.bind(this);
        menuLists = new ArrayList<PersonBean>();
        menuLists.add(new PersonBean("name1", "实时信息"));
        menuLists.add(new PersonBean("name2", "提醒通知"));
        menuLists.add(new PersonBean("name3", "活动路线"));
        menuLists.add(new PersonBean("name4", "相关设置"));
        myAdapter = new MyBaseAdapter<PersonBean>(menuLists, R.layout.adapter_item) {
            @Override
            public void bindView(ViewHolder holder, PersonBean obj) {
                holder.setText(R.id.tv_t1, obj.getName());
                holder.setText(R.id.tv_t2, obj.getAddr());

            }
        };
        listLeftDrawer.setAdapter(myAdapter);
        listLeftDrawer.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ContentFragment contentFragment = new ContentFragment();
        Bundle args = new Bundle();
        args.putString("text", menuLists.get(position).getAddr());
        contentFragment.setArguments(args);
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.ly_content, contentFragment).commit();
        drawerLayout.closeDrawer(listLeftDrawer);
    }

}
