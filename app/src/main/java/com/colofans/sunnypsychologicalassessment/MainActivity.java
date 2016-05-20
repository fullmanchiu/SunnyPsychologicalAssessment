package com.colofans.sunnypsychologicalassessment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.colofans.sunnypsychologicalassessment.fragment.FragmentController;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup mRadioGroup;
    private FragmentController controller;
    private Toolbar toolbar;
    private TextView toolbarTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = FragmentController.getInstance(this, R.id.fragment);
        controller.showFragment(0);
        initView();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.ReflashList");
//注册receiver
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                controller.showFragment(3);
            }
        }, filter);
    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.main_rg);
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        toolbarTv = (TextView) toolbar.findViewById(R.id.toolbar_tv);
        toolbarTv.setText(getText(R.string.tabbar_text_news));
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_news:
                controller.showFragment(0);
                toolbarTv.setText(getText(R.string.tabbar_text_news));
                break;
            case R.id.rb_test:
                controller.showFragment(1);
                toolbarTv.setText(getText(R.string.tabbar_text_test));
                break;
            case R.id.rb_history:
                controller.showFragment(2);
                toolbarTv.setText(getText(R.string.tabbar_text_consult));
                break;
            case R.id.rb_other:
                controller.showFragment(3);
                toolbarTv.setText(getText(R.string.tabbar_text_record));
                break;
            default:
                break;
        }
    }
}
