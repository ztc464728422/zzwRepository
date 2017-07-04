package com.test.zzw.zzwapp.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import com.test.zzw.zzwapp.R;
import com.zzw.aidl.IRemoteService;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zzw on 2017/4/26.
 */

public class TestAIDLDDActivity extends Activity {
    private IRemoteService remoteService;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testbindser);
        ButterKnife.bind(this);
    }

    ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("zzw1", "连不上");

        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            remoteService = IRemoteService.Stub.asInterface(service);
            try {
                int pid = remoteService.getPid();
                int currentPid = 12;
                System.out.println("currentPID: " + currentPid + "  remotePID: " + pid);
                Log.e("zzw1", "currentPID: " + currentPid + "  remotePID: " + pid);
                remoteService.basicTypes(12, 1223, true, 12.2f, 12.3, "我们的爱，我明白");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            System.out.println("bind success! " + remoteService.toString());
        }
    };

    /**
     * 监听按钮点击
     *
     * @param view
     */

    public void buttonClick(View view) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
    }

    @OnClick(R.id.btn_bindserice)
    public void onClick() {
        Log.e("zzw1", "begin bindService");
        System.out.println("begin bindService");
        Intent mIntent = new Intent();
        mIntent.setAction("duanqing.test.aidl");//你定义的service的action
        mIntent.setPackage("com.test.zzw.ipcapplication");//这里你需要设置你应用的包名
        bindService(mIntent, conn, Context.BIND_AUTO_CREATE);
    }
}
