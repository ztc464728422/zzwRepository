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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.test.zzw.zzwapp.R;
import com.test.zzw.zzwapp.bean.Person;
import com.test.zzw.zzwapp.bean.Salary;
import com.zzw.aidl.ISalary;

import butterknife.ButterKnife;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by zzw on 2017/5/2.
 * 自定义类型aidl测试
 */

public class AIDLComplexActivity extends Activity {

    @BindView(R.id.et_person)
    EditText etPerson;
    @BindView(R.id.btn_do)
    Button btnDo;
    @BindView(R.id.tv_salary)
    TextView tvSalary;
    private ISalary iSalary;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl_complex);
        ButterKnife.bind(this);

    }

    ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iSalary = ISalary.Stub.asInterface(service);
            try {
                Salary s = iSalary.getMsg(new Person(1,etPerson.getText().toString()));
                Log.e("zzwcom", "==== "+s.toString() );
            } catch (RemoteException e) {
                e.printStackTrace();
            }
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

    @OnClick(R.id.btn_do)
    public void onClick() {
        Log.e("zzw1", "begin bindService");
        System.out.println("begin bindService");
        Intent mIntent = new Intent();
        mIntent.setAction("android.intent.action.AIDLService2");//你定义的service的action
        mIntent.setPackage("com.test.zzw.ipcapplication");//这里你需要设置你应用的包名
        bindService(mIntent, conn, Context.BIND_AUTO_CREATE);
    }

}
