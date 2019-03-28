package com.eetown.broadcasttest.broadcastrecevier;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.eetown.broadcasttest.MainActivity;

/**
 * Created with IDEA
 *
 * @Author:Elvis
 * @Date:2019/3/28
 * @Time:10:11
 * @Description:
 */
public class NetworkChangeRecevier extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: 2019/3/28  somethings
        //  Toast.makeText(context, "NetWork had changed", Toast.LENGTH_LONG).show();

        //better  optimization hint
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            Toast.makeText(context, "NetWork is  connected", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(context, "NetWork is  unavailable", Toast.LENGTH_LONG).show();
        }

    }
}
