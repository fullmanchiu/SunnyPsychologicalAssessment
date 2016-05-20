package com.colofans.sunnypsychologicalassessment;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.colofans.sunnypsychologicalassessment.db.TestService;
import com.colofans.sunnypsychologicalassessment.utils.IntentFactory;

import java.util.ArrayList;

public class TestNoticeActivity extends AppCompatActivity {
    private int testCasePositon;
    private ArrayList<String> testTitles;
    private ImageView iv;
    private TextView tv;
    private Button btn;
    private int[] img;
    private String[] testCaseDescribe;
    private TestScale testScale;
    private Context mContext;
    private TestService testService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_notice);
        mContext = this;
        Intent intent = getIntent();
        testCasePositon = intent.getIntExtra("testCase", 0);
        Log.i("Lance", "testCasePositon:" + testCasePositon);
        initViews();
        initDatas();
        tv.setText(testScale.getTestScaleDescribe());
        initListeners();

    }

    private void initListeners() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(IntentFactory.testNotice2Test(getBaseContext(), testScale));
                finish();
            }
        });
    }

    private void initDatas() {
        TestService testService = new TestService(mContext);
        testScale = testService.getTestData(testCasePositon);

    }

    private void initViews() {
        setTitle(getTestTitle(testCasePositon));
        iv = (ImageView) findViewById(R.id.activity_test_notice_iv);
        tv = (TextView) findViewById(R.id.activity_test_notice_tv);
        btn = (Button) findViewById(R.id.activity_test_notice_btn);
        TypedArray array = getResources().obtainTypedArray(R.array.test_img);
        int len = array.length();
        img = new int[len];
        for (int i = 0; i < len; i++)
            img[i] = array.getResourceId(i, 0);
        array.recycle();
        iv.setBackground(getResources().getDrawable(img[testCasePositon]));

    }

    private String getTestTitle(int positon) {
        testService = new TestService(mContext);
        testTitles = testService.getTableLabel();
        //testTitles = getResources().getStringArray(R.array.test_case);
        return testTitles.get(positon);
    }
}
