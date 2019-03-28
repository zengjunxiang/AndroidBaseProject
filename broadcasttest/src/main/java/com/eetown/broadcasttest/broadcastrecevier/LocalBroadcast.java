package com.eetown.broadcasttest.broadcastrecevier;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created with IDEA
 *
 * @Author:Elvis
 * @Date:2019/3/28
 * @Time:14:49
 * @Description:
 */
public class LocalBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context,"recevied in localbroadcast",Toast.LENGTH_LONG).show();
    }
}
