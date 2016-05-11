package com.colofans.sunnypsychologicalassessment;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.colofans.sunnypsychologicalassessment.db.DBHelper;
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
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Log.i("Lance", "NEW DB" + dbHelper.getDatabaseName());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(IntentFactory.splash2Main(context));
            }
        },1000 * 2);
    }
}
