package com.eetown.broadcasttest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.eetown.broadcasttest.broadcastrecevier.MyBroadcastRecevier;
import com.eetown.broadcasttest.broadcastrecevier.NetworkChangeRecevier;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "MainActivity";
    private final String NET_CONNECT_CHANGGE = "android.net.conn.CONNECTIVITY_CHANGE";
    private IntentFilter mIntentFilter;
    private NetworkChangeRecevier mNetworkChangeRecevier;
    private Button mButton;
    private MyBroadcastRecevier mMyBroadcastRecevier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(NET_CONNECT_CHANGGE);

        mNetworkChangeRecevier = new NetworkChangeRecevier();

        //动态注册的广播,一定要取消
        registerReceiver(mNetworkChangeRecevier, mIntentFilter);

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
        unregisterReceiver(mMyBroadcastRecevier);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.send_mybroadcast_btn:

                Intent intent = new Intent();
                intent.setAction("com.eetown.broadcasttest.MyBroadcast");

                //
//                IntentFilter intentFilter = new IntentFilter();
//                intentFilter.addAction("com.eetown.broadcasttest.MyBroadcast");
//
//                mMyBroadcastRecevier = new MyBroadcastRecevier();
//                registerReceiver(mMyBroadcastRecevier, intentFilter);

                //intent.setComponent(new ComponentName("com.eetown.broadcasttest", "com.eetown.broadcasttest.MyBroadcast"));
                  sendOrderedBroadcast(intent,null);
                break;

            default:
                break;
        }
    }
}
