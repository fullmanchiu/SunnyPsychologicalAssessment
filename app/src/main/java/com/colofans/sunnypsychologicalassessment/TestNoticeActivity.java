package com.colofans.sunnypsychologicalassessment;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.colofans.sunnypsychologicalassessment.db.DBHelper;
import com.colofans.sunnypsychologicalassessment.utils.IntentFactory;

import java.util.ArrayList;

public class TestNoticeActivity extends AppCompatActivity {
    private int testCasePositon;
    private String[] testTitles;
    private ImageView iv;
    private TextView tv;
    private Button btn;
    private int[] img;
    private String[] testCaseDescribe;
    private TestScale testScale;
    private Context mContext;

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
        initListeners();

    }

    private void initListeners() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //testScale = new TestScale(,);
                startActivity(IntentFactory.testNotice2Test(getBaseContext(), testScale));
            }
        });
    }

    private void initDatas() {
        geTestScaleByPosition();
    }

    private void geTestScaleByPosition() {
        int scaleId = testCasePositon + 1;
        if (scaleId == 1) {
            DBHelper dbHelper = new DBHelper(mContext);
            SQLiteDatabase sqliteDatabase = dbHelper.getReadableDatabase();
            //查询表中的数据
            Cursor cursor = sqliteDatabase.query("scale", null, null, null, null, null, null);
            cursor.moveToFirst();
            int nameIndex = cursor.getColumnIndex("name");
            int descriptionIndex = cursor.getColumnIndex("description");
            int lengthIndex = cursor.getColumnIndex("length");
            String name = cursor.getString(nameIndex);
            String description = cursor.getString(descriptionIndex);
            int length = cursor.getInt(lengthIndex);
            Log.i("Lance", "name:" + name + " description:" + description + " length:" + length);
            cursor.close();
            cursor = sqliteDatabase.query("yale", null, null, null, null, null, null);
            TestScaleQuestion testScaleQuestion;
            int questionIdIndex = cursor.getColumnIndex("qid");
            int questionTitleIndex = cursor.getColumnIndex("title");
            int optionAIndex = cursor.getColumnIndex("optionA");
            int optionBIndex = cursor.getColumnIndex("optionB");
            int optionCIndex = cursor.getColumnIndex("optionC");
            int optionDIndex = cursor.getColumnIndex("optionD");
            int optionEIndex = cursor.getColumnIndex("optionE");
            int weightAIndex = cursor.getColumnIndex("weightA");
            int weightBIndex = cursor.getColumnIndex("weightB");
            int weightCIndex = cursor.getColumnIndex("weightC");
            int weightDIndex = cursor.getColumnIndex("weightD");
            int weightEIndex = cursor.getColumnIndex("weightE");
            int questionId;
            String questionTitle;
            String optionA;
            String optionB;
            String optionC;
            String optionD;
            String optionE;
            double weightA;
            double weightB;
            double weightC;
            double weightD;
            double weightE;
            ArrayList<TestScaleQuestion> questions = new ArrayList<TestScaleQuestion>();
            while (cursor.moveToNext()) {
                questionId = cursor.getInt(questionIdIndex);
                questionTitle = cursor.getString(questionTitleIndex);
                optionA = cursor.getString(optionAIndex);
                optionB = cursor.getString(optionBIndex);
                optionC = cursor.getString(optionCIndex);
                optionD = cursor.getString(optionDIndex);
                optionE = cursor.getString(optionEIndex);
                weightA = cursor.getInt(weightAIndex);
                weightB = cursor.getInt(weightBIndex);
                weightC = cursor.getInt(weightCIndex);
                weightD = cursor.getInt(weightDIndex);
                weightE = cursor.getInt(weightEIndex);
                testScaleQuestion = new TestScaleQuestion(questionId, questionTitle, optionA
                        , optionB, optionC, optionD, optionE, weightA, weightB, weightC, weightD, weightE);
                questions.add(testScaleQuestion);

            }
            testScale = new TestScale(1, name, 10, description, questions);

        }
        //testScale = new TestScale(1,)
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
