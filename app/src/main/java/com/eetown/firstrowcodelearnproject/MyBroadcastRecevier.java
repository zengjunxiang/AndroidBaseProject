package com.eetown.firstrowcodelearnproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created with IDEA
 *
 * @Author:Elvis
 * @Date:2019/3/28
 * @Time:11:39
 * @Description:
 */
public class MyBroadcastRecevier extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"recevied in  MyBroadcastRecevier from  broadcastrecevier",Toast.LENGTH_LONG).show();

    }
}
