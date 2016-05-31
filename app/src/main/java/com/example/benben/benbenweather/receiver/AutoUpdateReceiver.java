package com.example.benben.benbenweather.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.benben.benbenweather.service.AutoUpdateServiece;

/**
 * Created by benebn on 2016/5/31.
 */
public class AutoUpdateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, AutoUpdateServiece.class));
    }
}
