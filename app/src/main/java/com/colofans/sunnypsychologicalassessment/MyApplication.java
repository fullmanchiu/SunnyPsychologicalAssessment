package com.colofans.sunnypsychologicalassessment;

import android.app.Application;

import com.baidu.apistore.sdk.ApiStoreSDK;

/**
 * Created by Castor on 2016/5/20.
 */
public class MyApplication extends Application {
    private static final String APPKEY = "0b47ff92ddfef159b1dfa52f623b511f";

    @Override
    public void onCreate() {
        super.onCreate();
        ApiStoreSDK.init(this, APPKEY);
    }
}
