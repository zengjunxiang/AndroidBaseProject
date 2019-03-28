package com.eetown.broadcasttest;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.eetown.broadcasttest.broadcastrecevier.NetworkChangeRecevier;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private final String NET_CONNECT_CHANGGE = "android.net.conn.CONNECTIVITY_CHANGE";
    private IntentFilter mIntentFilter;
    private NetworkChangeRecevier mNetworkChangeRecevier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(NET_CONNECT_CHANGGE);

        mNetworkChangeRecevier = new NetworkChangeRecevier();

        //动态注册的广播,一定要取消
        registerReceiver(mNetworkChangeRecevier, mIntentFilter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mNetworkChangeRecevier);
    }

}
