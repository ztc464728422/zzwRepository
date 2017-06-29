//package com.test.zzw.zzwapp.service;
//
//import android.app.IntentService;
//import android.content.Intent;
//import android.os.Binder;
//import android.os.IBinder;
//import android.util.Log;
//
///**
// * Created by zzw on 2017/4/26.
// */
//
//public class TestIntentService extends IntentService {
//    private final String TAG = "hehe";
//
//    private  int count = 0;
//    //必须实现父类的构造方法
//    public TestIntentService()
//    {
//        super("TestService3");
//    }
//
//    private MyBinder myBinder = new MyBinder();
//
//    public class MyBinder extends Binder{
//        public int getCount(){
//            return count;
//        }
//    }
//
//
//
//    //必须重写的核心方法
//    @Override
//    protected void onHandleIntent(Intent intent) {
//        //Intent是从Activity发过来的，携带识别参数，根据参数不同执行不同的任务
//        String action = intent.getExtras().getString("param");
//        if(action.equals("s1")) Log.i(TAG,"启动service1");
//        else if(action.equals("s2"))Log.i(TAG,"启动service2");
//        else if(action.equals("s3"))Log.i(TAG,"启动service3");
//
//        //让服务休眠2秒
//        try{
//            count++;
//            Thread.sleep(3000);
//
//            Log.i(TAG,"service"+action+"结束");
//        }catch(InterruptedException e){e.printStackTrace();}
//    }
//
//    //重写其他方法,用于查看方法的调用顺序
//    @Override
//    public IBinder onBind(Intent intent) {
//        Log.i(TAG,"onBind");
//        return myBinder;
//    }
//
//    @Override
//    public void onCreate() {
//        Log.i(TAG,"onCreate");
//        super.onCreate();
//    }
//
//    @Override
//    public int onStartCommand(Intent intent, int flags, int startId) {
//        Log.i(TAG,"onStartCommand"+intent.getExtras().getString("param"));
//        return super.onStartCommand(intent, flags, startId);
//    }
//
//
//    @Override
//    public void setIntentRedelivery(boolean enabled) {
//        super.setIntentRedelivery(enabled);
//        Log.i(TAG,"setIntentRedelivery");
//    }
//
//    @Override
//    public void onDestroy() {
//        Log.i(TAG,"onDestroy");
//        super.onDestroy();
//    }
//
//}