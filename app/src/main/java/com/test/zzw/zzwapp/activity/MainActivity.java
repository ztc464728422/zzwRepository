package com.test.zzw.zzwapp.activity;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.test.zzw.zzwapp.R;
import com.test.zzw.zzwapp.bean.Person;
import com.test.zzw.zzwapp.db.MyDBOpenHelper;
import com.test.zzw.zzwapp.jni.JNIUtils;
import com.test.zzw.zzwapp.jni.JNIUtils2;
import com.test.zzw.zzwapp.utils.DomHelper;
import com.test.zzw.zzwapp.utils.SaxHelper;
import com.test.zzw.zzwapp.utils.ViewUtils;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MyBaseAppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initdb();
    }

    private void initdb() {
        MyDBOpenHelper my = new MyDBOpenHelper(this, "", null, 1);
        my.getWritableDatabase();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar adapter_item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view adapter_item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick({R.id.btn_jni, R.id.btn_testpage, R.id.btn_tesdrawerlayout,
            R.id.btn_testmutilayiytadapter, R.id.btn_testbindservice,
            R.id.btn_aidl, R.id.btn_com_aidl, R.id.btn_transact,
            R.id.btn_sax_xml, R.id.btn_dom_xml,R.id.btn_databinding,R.id.btn_rxjava})
    public void onClick(View v) {
        if (ViewUtils.isFastDoubleClick()) {
            return;
        }
        switch (v.getId()) {
            case R.id.btn_testpage:
                toActivity(TestAdActivity.class, false);
                break;
            case R.id.btn_tesdrawerlayout:
                toActivity(DrawerLayoutActivity.class, false);
                break;
            case R.id.btn_testmutilayiytadapter:
                try {
                    ActivityManager activityMgr = (ActivityManager) MainActivity.this
                            .getSystemService(Context.ACTIVITY_SERVICE);
                    activityMgr.killBackgroundProcesses(MainActivity.this.getPackageName());
                    System.exit(0);
                } catch (Exception ignored) {
                }
//                toActivity(MutiLayoutAdActivity.class, false);
//                Intent intent = getPackageManager().getLaunchIntentForPackage
//                        ("com.linkshop.client.activity.WelcomeActivity") ;
//                if(intent != null) startActivity(intent) ;

//                Intent mIntent = new Intent( );
//                ComponentName comp = new ComponentName("com.linkshop.client.activity", "WelcomeActivity");
//                mIntent.setComponent(comp);
//                mIntent.setAction("android.intent.action.VIEW");
//                startActivity(mIntent);
                break;
            case R.id.btn_testbindservice:
//                startActivity(new Intent(MainActivity.this, TestBindSerActivity.class));
                break;
            case R.id.btn_aidl:
                startActivity(new Intent(MainActivity.this, TestAIDLDDActivity.class));
                break;
            case R.id.btn_com_aidl:
                startActivity(new Intent(MainActivity.this, AIDLComplexActivity.class));
                break;
            case R.id.btn_transact:
                startActivity(new Intent(MainActivity.this, TransactActivity.class));
                break;
            case R.id.btn_sax_xml:
                try {
                    readxmlForSAX();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_dom_xml:
                DomHelper.queryXML(this);
                break;
            case R.id.btn_jni:
                startActivity(new Intent(mContext,TestActivity.class));
                Toast.makeText(this, new JNIUtils().fromVectortest(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_databinding:
                startActivity(new Intent(MainActivity.this, DataBindingActivity.class));
                break;
            case R.id.btn_rxjava:
                startActivity(new Intent(MainActivity.this, RxJavaTestActivity.class));
                break;
        }


    }

    private ArrayList<Person> readxmlForSAX() throws Exception {
        //获取文件资源建立输入流对象
        InputStream is = getAssets().open("person1.xml");
        //①创建XML解析处理器
        SaxHelper ss = new SaxHelper();
        //②得到SAX解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //③创建SAX解析器
        SAXParser parser = factory.newSAXParser();
        //④将xml解析处理器分配给解析器,对文档进行解析,将事件发送给处理器
        parser.parse(is, ss);
        is.close();
        return ss.getPersons();
    }

    /**
     * 跳转到下一个Activity
     *
     * @param cls       目标Activity
     * @param closeFlag 是否关闭当前Activity
     */
    protected void toActivity(Class<?> cls, boolean closeFlag) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
//        overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
        if (closeFlag)
            finish();
    }

}
