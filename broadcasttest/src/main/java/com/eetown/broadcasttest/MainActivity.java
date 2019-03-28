package com.eetown.broadcasttest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.eetown.broadcasttest.broadcastrecevier.LocalBroadcast;
import com.eetown.broadcasttest.broadcastrecevier.MyBroadcastRecevier;
import com.eetown.broadcasttest.broadcastrecevier.NetworkChangeRecevier;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "MainActivity";
    private final String NET_CONNECT_CHANGGE = "android.net.conn.CONNECTIVITY_CHANGE";
    private final String LOCAL_BROADCAST = "com.eetown.broadcasttest.LocalBroadcast";
    private IntentFilter mIntentFilter;
    private NetworkChangeRecevier mNetworkChangeRecevier;
    private Button mButton;
    private MyBroadcastRecevier mMyBroadcastRecevier;
    private LocalBroadcast mLocalBroadcast;
    private LocalBroadcastManager mLocalBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(NET_CONNECT_CHANGGE);

        mNetworkChangeRecevier = new NetworkChangeRecevier();

        //动态注册的广播,一定要取消
        registerReceiver(mNetworkChangeRecevier, mIntentFilter);

        //动态注册本地广播监听器，本地广播只能通过动态注册方式，  本地广播只在本应用内传递，保证了应用的安全性

        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        mLocalBroadcast = new LocalBroadcast();
                       IntentFilter intentFilter = new IntentFilter();
                                   intentFilter.addAction(LOCAL_BROADCAST);
        mLocalBroadcastManager.registerReceiver(mLocalBroadcast,intentFilter);

        initView();

        initEvent();
    }

    private void initEvent() {
        mButton.setOnClickListener(this);
    }

    private void initView() {
        mButton = (Button) findViewById(R.id.send_mybroadcast_btn);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销广播
      //  unregisterReceiver(mNetworkChangeRecevier);
      //  unregisterReceiver(mMyBroadcastRecevier);
        if (mLocalBroadcastManager != null) {
            unregisterReceiver(mLocalBroadcast);
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.send_mybroadcast_btn:

                Intent intent = new Intent();
                intent.setAction(LOCAL_BROADCAST);

                // TODO: 2019/3/28  待解决 静态注册广播在8.0系统及以上 无效问题
                //
//                IntentFilter intentFilter = new IntentFilter();
//                intentFilter.addAction("com.eetown.broadcasttest.MyBroadcast");
//
//                mMyBroadcastRecevier = new MyBroadcastRecevier();
//                registerReceiver(mMyBroadcastRecevier, intentFilter);
                //intent.setComponent(new ComponentName("com.eetown.broadcasttest", "com.eetown.broadcasttest.MyBroadcast"));

                //发送有序广播
                //  sendOrderedBroadcast(intent,null);

                //发送本地广播
                mLocalBroadcastManager.sendBroadcast(intent);


                break;

            default:
                break;
        }
    }
}
