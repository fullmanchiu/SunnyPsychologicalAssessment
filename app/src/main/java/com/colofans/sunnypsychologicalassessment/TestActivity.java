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
    private RadioButton rb1, rb2, rb3, rb4, rb5;
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
                        rb1.setChecked(true);
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
                if (index == testScale.getTestScaleLength() - 1) {
                    btn.setText("完成");
                }
                if (index < testScale.getTestScaleLength()) {
                    results.add(result);
                    rg.clearCheck();
                    tv.setText(index + 1 + "." + testScale.getQuestions().get(index).getQuestionTitle());
                    rb1.setText("A:" + testScale.getQuestions().get(index).getOptionA());
                    rb2.setText("B:" + testScale.getQuestions().get(index).getOptionB());
                    rb3.setText("C:" + testScale.getQuestions().get(index).getOptionC());
                    rb4.setText("D:" + testScale.getQuestions().get(index).getOptionD());
                    rb5.setText("E:" + testScale.getQuestions().get(index).getOptionE());
                }
                if (index >= testScale.getTestScaleLength()) {
                    getResult(testScale.getTestScaleId(), getResultScore(results));
                    Log.i("Lance", testScale.getTestScaleTitle());
                    startActivity(IntentFactory.test2Result(mContext, testScale));
                    finish();
                }
            }


        });
    }

    private void getResult(int testScaleId, int resultScore) {

        String resultSumarry = null;
        switch (testScaleId) {
            case 1:
                if (resultScore >= 0 && resultScore <= 5) {
                    resultSumarry = getResources().getString(R.string.yale_level0);
                } else if (resultScore >= 6 && resultScore <= 15) {
                    resultSumarry = getResources().getString(R.string.yale_level1);
                } else if (resultScore >= 16 && resultScore <= 25) {
                    resultSumarry = getResources().getString(R.string.yale_level2);
                } else if (resultScore > 25) {
                    resultSumarry = getResources().getString(R.string.yale_level3);
                }
                break;
            case 2:
                if (resultScore >= 0 && resultScore < 50) {
                    resultSumarry = getResources().getString(R.string.sas_lever0);
                } else if (resultScore >= 50 && resultScore <= 60) {
                    resultSumarry = getResources().getString(R.string.sas_lever1);
                } else if (resultScore >= 61 && resultScore <= 70) {
                    resultSumarry = getResources().getString(R.string.sas_lever2);
                } else if (resultScore >= 71) {
                    resultSumarry = getResources().getString(R.string.sas_lever3);
                }
                break;
            case 3:
                if (resultScore >= 0 && resultScore < 15) {
                    resultSumarry = getResources().getString(R.string.gses_lever0);
                } else if (resultScore >= 16 && resultScore <= 24) {
                    resultSumarry = getResources().getString(R.string.gses_lever1);
                } else if (resultScore >= 25 && resultScore <= 29) {
                    resultSumarry = getResources().getString(R.string.gses_lever2);
                } else if (resultScore >= 30) {
                    resultSumarry = getResources().getString(R.string.gses_lever3);
                }
                break;
            case 4:
                resultScore = (int) (resultScore * 1.25);
                if (resultScore >= 0 && resultScore < 52) {
                    resultSumarry = getResources().getString(R.string.sds_lever0);
                } else if (resultScore >= 53 && resultScore <= 62) {
                    resultSumarry = getResources().getString(R.string.sds_lever1);
                } else if (resultScore >= 63 && resultScore <= 72) {
                    resultSumarry = getResources().getString(R.string.sds_lever2);
                } else if (resultScore >= 73) {
                    resultSumarry = getResources().getString(R.string.sds_lever3);
                }
                break;
        }

        testScale.setTestScaleResult(resultSumarry);
        testScale.setTestScaleResultScore(resultScore);
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


        tv.setText("1." + testScale.getQuestions().get(index).getQuestionTitle());
        rb1.setText("A:" + testScale.getQuestions().get(index).getOptionA());
        rb2.setText("B:" + testScale.getQuestions().get(index).getOptionB());
        rb3.setText("C:" + testScale.getQuestions().get(index).getOptionC());
        rb4.setText("D:" + testScale.getQuestions().get(index).getOptionD());
        rb5.setText("E:" + testScale.getQuestions().get(index).getOptionE());
        ArrayList<RadioButton> radioButtons = new ArrayList<>();
        radioButtons.add(rb1);
        radioButtons.add(rb2);
        radioButtons.add(rb3);
        radioButtons.add(rb4);
        radioButtons.add(rb5);
        for (RadioButton radioButton : radioButtons) {
            Log.i("Lance", radioButton.getText().toString().substring(0, 2));
            if (radioButton.getText().toString().substring(2, radioButton.getText().length()).equals("")) {
                Log.i("Lance", "radioButton is empty");
                radioButton.setVisibility(View.INVISIBLE);
            }
        }
    }
}
