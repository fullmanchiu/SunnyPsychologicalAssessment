package com.colofans.sunnypsychologicalassessment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

import com.colofans.sunnypsychologicalassessment.fragment.FragmentController;

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup mRadioGroup;
    private FragmentController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = FragmentController.getInstance(this, R.id.fragment);
        controller.showFragment(0);
        initView();
    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.main_rg);
        mRadioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_news:
                controller.showFragment(0);
                break;
            case R.id.rb_test:
                controller.showFragment(1);
                break;
            case R.id.rb_history:
                controller.showFragment(2);
                break;
            case R.id.rb_other:
                controller.showFragment(3);
                break;
            default:
                break;
        }
    }
}
