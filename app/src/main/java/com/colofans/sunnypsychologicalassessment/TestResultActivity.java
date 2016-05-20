package com.colofans.sunnypsychologicalassessment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.colofans.sunnypsychologicalassessment.beans.TestRecord;
import com.colofans.sunnypsychologicalassessment.db.TestRecordService;

public class TestResultActivity extends AppCompatActivity {
    private Context mContext;
    private TestScale testScale;
    private TextView tvTitle, tvSummary, tvScore;
    private Button btn;
    private String title;
    private String summary;
    private String score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);
        mContext = this;
        Intent intent = getIntent();
        testScale = (TestScale) intent.getSerializableExtra("testScale");
        Log.i("Lance", "testScale" + testScale.toString());
        title = testScale.getTestScaleTitle();
        score = testScale.getTestScaleResultScore() + "";
        summary = testScale.getTestScaleResult();
        //title = intent.getStringExtra("name");
        //score = intent.getIntExtra("score",0)+"";
        //summary = intent.getStringExtra("result");
        initViews();
    }

    private void initViews() {
        tvTitle = (TextView) findViewById(R.id.test_result_title);
        tvScore = (TextView) findViewById(R.id.test_result_score);
        tvSummary = (TextView) findViewById(R.id.test_result_summary);
        btn = (Button) findViewById(R.id.test_result_btn);

        tvTitle.setText(title);
        tvScore.setText(tvScore.getText().toString() + score);
        Log.i("Lance", "summary" + summary);
        tvSummary.setText("summary:" + summary);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestRecord record = new TestRecord(tvTitle.getText().toString(), tvScore.getText().toString(), tvSummary.getText().toString());
                doSaveAction(record);
            }
        });
    }

    private void doSaveAction(TestRecord record) {
        TestRecordService testRecordService = new TestRecordService(mContext);
        testRecordService.addDevice(record);
        finish();
        //startActivity(IntentFactory.testResult2Record(mContext));
    }

}
