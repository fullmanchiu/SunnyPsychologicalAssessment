package com.colofans.sunnypsychologicalassessment;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Castor on 2016/5/11.
 */
public class TestScale implements Serializable {
    private int testScaleId;
    private String testScaleTitle;
    private int testScaleLength;
    private String testScaleDescribe;
    private int testScaleResultScore;
    private String testScaleResult;
    private ArrayList<TestScaleQuestion> questions;

    public TestScale(int testScaleId, String testScaleTitle, int testScaleLength, String testScaleDescribe, ArrayList<TestScaleQuestion> questions) {
        this.testScaleId = testScaleId;
        this.testScaleTitle = testScaleTitle;
        this.testScaleLength = testScaleLength;
        this.testScaleDescribe = testScaleDescribe;
        this.questions = questions;
    }


    public int getTestScaleId() {
        return testScaleId;
    }

    public void setTestScaleId(int testScaleId) {
        this.testScaleId = testScaleId;
    }

    public String getTestScaleTitle() {
        return testScaleTitle;
    }

    public void setTestScaleTitle(String testScaleTitle) {
        this.testScaleTitle = testScaleTitle;
    }

    public int getTestScaleLength() {
        return testScaleLength;
    }

    public void setTestScaleLength(int testScaleLength) {
        this.testScaleLength = testScaleLength;
    }

    public String getTestScaleDescribe() {
        return testScaleDescribe;
    }

    public void setTestScaleDescribe(String testScaleDescribe) {
        this.testScaleDescribe = testScaleDescribe;
    }

    public String getTestScaleResult() {
        return testScaleResult;
    }

    public void setTestScaleResult(String testScaleResult) {
        this.testScaleResult = testScaleResult;
    }

    public ArrayList<TestScaleQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<TestScaleQuestion> questions) {
        this.questions = questions;
    }

    public int getTestScaleResultScore() {
        return testScaleResultScore;
    }

    public void setTestScaleResultScore(int testScaleResultScore) {
        this.testScaleResultScore = testScaleResultScore;
    }
}
