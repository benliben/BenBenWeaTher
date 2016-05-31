package com.example.benben.benbenweather.util;

/**
 * Created by beneben on 2016/5/31.
 */
public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
