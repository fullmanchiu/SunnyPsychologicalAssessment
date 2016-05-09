package com.colofans.sunnypsychologicalassessment;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.colofans.sunnypsychologicalassessment.utils.IntentFactory;

public class TestNoticeActivity extends AppCompatActivity {
    private int testCasePositon;
    private String[] testTitles;
    private ImageView iv;
    private TextView tv;
    private Button btn;
    private int[] img;
    private String[] testCaseDescribe;
    private TestCase testCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_notice);
        Intent intent = getIntent();
        testCasePositon = intent.getIntExtra("testCase", 0);
        initViews();
        initDatas();
        initListeners();

    }

    private void initListeners() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(IntentFactory.testNotice2Test(getParent(), testCase));
            }
        });
    }

    private void initDatas() {
        getTestCaseByPosition();
    }

    private void getTestCaseByPosition() {
        String[] itemTitles = getResources().getStringArray(R.array.item_titles);
        // TestCaseItem item = new TestCaseItem()
    }

    private void initViews() {
        setTitle(getTestTitle(testCasePositon));
        iv = (ImageView) findViewById(R.id.activity_test_notice_iv);
        tv = (TextView) findViewById(R.id.activity_test_notice_tv);
        btn = (Button) findViewById(R.id.activity_test_notice_btn);
        testCaseDescribe = getResources().getStringArray(R.array.test_describe);
        TypedArray array = getResources().obtainTypedArray(R.array.test_img);
        int len = array.length();
        img = new int[len];
        for (int i = 0; i < len; i++)
            img[i] = array.getResourceId(i, 0);
        array.recycle();
        iv.setBackground(getResources().getDrawable(img[testCasePositon]));
        tv.setText(testCaseDescribe[testCasePositon]);

    }

    private String getTestTitle(int positon) {
        testTitles = getResources().getStringArray(R.array.test_case);
        return testTitles[positon];
    }
}
