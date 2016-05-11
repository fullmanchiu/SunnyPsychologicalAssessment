package com.colofans.sunnypsychologicalassessment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class TestResultActivity extends AppCompatActivity {
    private Context mContext;
    //private TestScale testScale1;
    private TextView tvTitle, tvSummary;
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
        title = intent.getStringExtra("name");
        summary = intent.getStringExtra("result");
        //score = intent.getIntExtra("resultcore",0)+"";
        //Log.i("Lance",testScale.getTestScaleTitle());
        initViews();
    }

    private void initViews() {
        tvTitle = (TextView) findViewById(R.id.test_result_title);
        //tvScore = (TextView) findViewById(R.id.test_result_score);
        tvSummary = (TextView) findViewById(R.id.test_result_summary);
        btn = (Button) findViewById(R.id.test_result_btn);

        tvTitle.setText(title);
        //tvScore.setText(score);
        tvSummary.setText(summary);
    }
}
