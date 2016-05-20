package com.colofans.sunnypsychologicalassessment.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.colofans.sunnypsychologicalassessment.TestScale;
import com.colofans.sunnypsychologicalassessment.TestScaleQuestion;

import java.util.ArrayList;

/**
 * Created by Castor on 2016/5/20.
 */
public class TestService {
    private TestScale testScale;
    private DBHelper dbHelper;

    public TestService(Context mContext) {
        dbHelper = new DBHelper(mContext);
    }


    public TestScale getTestData(int i) {
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        testScale = getData(sdb, i);
        return testScale;
    }

    private TestScale getData(SQLiteDatabase sdb, int i) {
        //查询表中的数据
        Cursor cursor = sdb.query("scale", null, null, null, null, null, null);
        cursor.moveToPosition(i);
        int nameIndex = cursor.getColumnIndex("name");
        int descriptionIndex = cursor.getColumnIndex("description");
        int lengthIndex = cursor.getColumnIndex("length");
        String name = cursor.getString(nameIndex);
        String description = cursor.getString(descriptionIndex);
        int length = cursor.getInt(lengthIndex);
        Log.i("Lance", "name:" + name + " description:" + description + " length:" + length);
        cursor.close();
        cursor = sdb.query(getTableName(i), null, null, null, null, null, null);
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
        testScale = new TestScale(i + 1, name, questions.size(), description, questions);
        return testScale;
    }


    private String getTableName(int i) {
        String tableName = null;
        switch (i) {
            case 0:
                tableName = TestScale.SCALE_YALE;
                break;
            case 1:
                tableName = TestScale.SCALE_SAS;
                break;
            case 2:
                tableName = TestScale.SCALE_GSES;
                break;
            case 3:
                tableName = TestScale.SCALE_SDS;
                break;
            case 4:
                tableName = TestScale.SCALE_EQ;
        }
        return tableName;
    }

    // private TestScale getSasData(SQLiteDatabase sdb) {
    // Cursor
    //return
    //  }

    private TestScale getYaleData(SQLiteDatabase sdb) {
        //查询表中的数据
        Cursor cursor = sdb.query("scale", null, null, null, null, null, null);
        cursor.moveToPosition(0);
        int nameIndex = cursor.getColumnIndex("name");
        int descriptionIndex = cursor.getColumnIndex("description");
        int lengthIndex = cursor.getColumnIndex("length");
        String name = cursor.getString(nameIndex);
        String description = cursor.getString(descriptionIndex);
        int length = cursor.getInt(lengthIndex);
        Log.i("Lance", "name:" + name + " description:" + description + " length:" + length);
        cursor.close();
        cursor = sdb.query("yale", null, null, null, null, null, null);
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
        return testScale;
    }

    public ArrayList<String> getTableLabel() {
        ArrayList<String> list = new ArrayList<>();
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        Cursor cursor = sdb.query("scale", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            list.add(cursor.getString(cursor.getColumnIndex("name")));
        }
        return list;
    }

}
