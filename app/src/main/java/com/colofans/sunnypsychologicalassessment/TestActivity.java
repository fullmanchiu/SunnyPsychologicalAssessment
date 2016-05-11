package com.colofans.sunnypsychologicalassessment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.colofans.sunnypsychologicalassessment.utils.IntentFactory;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {
    private TextView tv;
    private Button btn;
    private RadioGroup rg;
    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6;
    private int result;
    private int index = 0;
    private TestScale testScale;
    ArrayList<Integer> results;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mContext = this;
        Intent intent = getIntent();
        testScale = (TestScale) intent.getSerializableExtra("testScale");
        if (testScale == null) {
            Toast.makeText(this, "not support", Toast.LENGTH_LONG).show();
            startActivity(IntentFactory.splash2Main(mContext));
            this.finish();
        }
        String title = testScale.getTestScaleTitle();
        results = new ArrayList<Integer>();
        setTitle(title);
        initViews();
        initListeners();
    }

    private void initListeners() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.option_a:
                        result = (int) testScale.getQuestions().get(index).getWeightA();
                        Log.i("Lance", "resulta:" + result);
                        break;
                    case R.id.option_b:
                        result = (int) testScale.getQuestions().get(index).getWeightB();
                        Log.i("Lance", "resultb:" + result);
                        break;
                    case R.id.option_c:
                        result = (int) testScale.getQuestions().get(index).getWeightC();
                        Log.i("Lance", "resultc:" + result);
                        break;
                    case R.id.option_d:
                        result = (int) testScale.getQuestions().get(index).getWeightD();
                        Log.i("Lance", "resultd:" + result);
                        break;
                    case R.id.option_e:
                        result = (int) testScale.getQuestions().get(index).getWeightE();
                        Log.i("Lance", "resulte:" + result);
                        break;
                    default:
                        break;
                }
                Log.i("Lance", "result:" + result);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                Log.i("Lance", "index:" + index);
                if (index < 10) {
                    rg.clearCheck();
                    results.add(result);
                    tv.setText(testScale.getQuestions().get(index).getQuestionTitle());
                    rb1.setText(testScale.getQuestions().get(index).getOptionA());
                    rb2.setText(testScale.getQuestions().get(index).getOptionB());
                    rb3.setText(testScale.getQuestions().get(index).getOptionC());
                    rb4.setText(testScale.getQuestions().get(index).getOptionD());
                    rb5.setText(testScale.getQuestions().get(index).getOptionE());
                }
                if (index >= 10) {
                    getResult(getResultScore(results));
                    Log.i("Lance", testScale.getTestScaleTitle());
                    startActivity(IntentFactory.test2Result(mContext, testScale));
                }
            }


        });
    }

    private void getResult(int resultScore) {
        String resultSumarry = null;
        if (resultScore >= 6 && resultScore <= 15) {
            resultSumarry = getResources().getString(R.string.yale_level1);
        } else if (resultScore >= 16 && resultScore <= 25) {
            resultSumarry = getResources().getString(R.string.yale_level2);
        } else if (resultScore > 25) {
            resultSumarry = getResources().getString(R.string.yale_level3);
        }
        testScale.setTestScaleResult(resultSumarry);
    }


    private int getResultScore(ArrayList<Integer> results) {
        int result = 0;
        for (int i : results) {
            result = result + i;
        }
        Log.i("Lance", "result:" + result);
        testScale.setTestScaleResultScore(result);
        return result;
    }

    private void initViews() {
        tv = (TextView) findViewById(R.id.activity_test_tv);
        btn = (Button) findViewById(R.id.activity_test_btn);
        rg = (RadioGroup) findViewById(R.id.radio_group);
        rb1 = (RadioButton) findViewById(R.id.option_a);
        rb2 = (RadioButton) findViewById(R.id.option_b);
        rb3 = (RadioButton) findViewById(R.id.option_c);
        rb4 = (RadioButton) findViewById(R.id.option_d);
        rb5 = (RadioButton) findViewById(R.id.option_e);
        tv.setText(testScale.getQuestions().get(index).getQuestionTitle());
        rb1.setText(testScale.getQuestions().get(index).getOptionA());
        rb2.setText(testScale.getQuestions().get(index).getOptionB());
        rb3.setText(testScale.getQuestions().get(index).getOptionC());
        rb4.setText(testScale.getQuestions().get(index).getOptionD());
        rb5.setText(testScale.getQuestions().get(index).getOptionE());
    }
}
