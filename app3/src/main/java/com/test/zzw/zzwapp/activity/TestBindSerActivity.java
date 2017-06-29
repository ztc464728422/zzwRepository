//package com.test.zzw.zzwapp.activity;
//
//import android.app.Activity;
//import android.app.Service;
//import android.content.ComponentName;
//import android.content.Intent;
//import android.content.ServiceConnection;
//import android.os.Bundle;
//import android.os.IBinder;
//import android.view.View;
//import android.widget.Toast;
//
//import com.test.zzw.zzwapp.R;
//import com.test.zzw.zzwapp.service.TestBindService;
////import com.test.zzw.zzwapp.service.TestIntentService;
//
//import butterknife.ButterKnife;
//import butterknife.OnClick;
//
///**
// * Created by zzw on 2017/4/26.
// */
//
//public class TestBindSerActivity extends Activity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_testbindser);
//        ButterKnife.inject(this);
//    }
//
//    //保持所启动的Service的IBinder对象,同时定义一个ServiceConnection对象
//    TestBindService.MyBinder binder;
//    private ServiceConnection conn = new ServiceConnection() {
//
//        //Activity与Service断开连接时回调该方法
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            System.out.println("------Service DisConnected-------");
//        }
//
//        //Activity与Service连接成功时回调该方法
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            System.out.println("------Service Connected-------");
//            binder = (TestBindService.MyBinder) service;
//        }
//    };
//
//    @OnClick({R.id.btn_bindserice, R.id.btn_unbindserice, R.id.btn_status})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.btn_bindserice:
//                final Intent intent = new Intent(TestBindSerActivity.this, TestBindService.class);
////                intent.setAction("com.jay.example.service.TEST_SERVICE2");
//                //绑定service
//                bindService(intent, conn, Service.BIND_AUTO_CREATE);
//                break;
//            case R.id.btn_unbindserice:
//                unbindService(conn);
//                break;
//            case R.id.btn_status:
////                Toast.makeText(getApplicationContext(), "Service的count的值为:"
////                        + binder.getCount(), Toast.LENGTH_SHORT).show();
////                Toast.makeText(getApplicationContext(), "intnentService的count的值为:"
////                        + testIntentService.getCount(), Toast.LENGTH_SHORT).show();
//                break;
//        }
//    }
//
//    @OnClick(R.id.btn_start)
//    public void onClick() {
//        Intent it1 =  new Intent(TestBindSerActivity.this,TestIntentService.class);
//        Bundle b1 = new Bundle();
//        b1.putString("param", "s1");
//        it1.putExtras(b1);
//
//        Intent it2 = new Intent(TestBindSerActivity.this,TestIntentService.class);
//        Bundle b2 = new Bundle();
//        b2.putString("param", "s2");
//        it2.putExtras(b2);
//
//        Intent it3 = new Intent(TestBindSerActivity.this,TestIntentService.class);
//        Bundle b3 = new Bundle();
//        b3.putString("param", "s3");
//        it3.putExtras(b3);
//
//        //接着启动多次IntentService,每次启动,都会新建一个工作线程
//        //但始终只有一个IntentService实例
//
//        startService(it1);
//        startService(it2);
//        startService(it3);
//
//        bindService(it1, conn2, Service.BIND_AUTO_CREATE);
//        bindService(it2, conn2, Service.BIND_AUTO_CREATE);
//        bindService(it3, conn2, Service.BIND_AUTO_CREATE);
//
//
//    }
//
//    TestIntentService.MyBinder testIntentService;
//
//    ServiceConnection conn2 = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
//            testIntentService = (TestIntentService.MyBinder) iBinder;
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName componentName) {
//
//        }
//    };
//}
