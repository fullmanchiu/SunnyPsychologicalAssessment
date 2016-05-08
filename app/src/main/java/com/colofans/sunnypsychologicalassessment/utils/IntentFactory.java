package com.colofans.sunnypsychologicalassessment.utils;

import android.content.Context;
import android.content.Intent;

import com.colofans.sunnypsychologicalassessment.MainActivity;

/**
 * Created by fullm on 2016/5/8.
 */
public class IntentFactory {
    private static Intent intent;
    public static Intent splash2Main(Context context) {
        intent =  new Intent();
        intent.setClass(context, MainActivity.class);
        return intent;
    }
}
