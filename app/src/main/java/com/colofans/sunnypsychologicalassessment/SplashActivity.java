package com.colofans.sunnypsychologicalassessment;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.colofans.sunnypsychologicalassessment.utils.IntentFactory;

public class SplashActivity extends Activity {
    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(IntentFactory.splash2Main(context));
            }
        },1000 * 2);
    }
}
