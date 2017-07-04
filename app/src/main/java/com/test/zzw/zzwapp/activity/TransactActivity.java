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
import android.widget.Toast;

import com.test.zzw.zzwapp.R;
import com.test.zzw.zzwapp.bean.Person;
import com.test.zzw.zzwapp.bean.Salary;
import com.zzw.aidl.ISalary;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zzw on 2017/5/2.
 * 自定义类型aidl测试
 */

public class TransactActivity extends Activity {

    @BindView(R.id.et_person)
    EditText etPerson;
    @BindView(R.id.btn_do)
    Button btnDo;
    @BindView(R.id.tv_salary)
    TextView tvSalary;
    private ISalary iSalary;

    private IBinder mIBinder;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl_complex);
        ButterKnife.bind(this);
        Log.e("zzw1", "begin bindService");
        System.out.println("begin bindService");
        Intent mIntent = new Intent();
        mIntent.setAction("android.intent.action.IPCService");//你定义的service的action
        mIntent.setPackage("com.test.zzw.ipcapplication");//这里你需要设置你应用的包名
        bindService(mIntent, conn, Context.BIND_AUTO_CREATE);
    }

    ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mIBinder = null;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mIBinder = service;
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
        int num = Integer.parseInt(etPerson.getText().toString());
        if (mIBinder == null)
        {
            Toast.makeText(this, "未连接服务端或服务端被异常杀死", Toast.LENGTH_SHORT).show();
        } else {
            android.os.Parcel _data = android.os.Parcel.obtain();
            android.os.Parcel _reply = android.os.Parcel.obtain();
            String _result = null;
            try{
                _data.writeInterfaceToken("IPCService");
                _data.writeInt(num);
                mIBinder.transact(0x001, _data, _reply, 0);
                _reply.readException();
                _result = _reply.readString();
                tvSalary.setText(_result);
                etPerson.setText("");
            }catch (RemoteException e)
            {
                e.printStackTrace();
            } finally
            {
                _reply.recycle();
                _data.recycle();
            }
        }
    }

}
