package com.colofans.sunnypsychologicalassessment;

import java.io.Serializable;

/**
 * Created by Castor on 2016/5/11.
 */
public class TestScaleQuestion implements Serializable {
    private int questionId;
    private String questionTitle;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String optionE;
    private double weightA;
    private double weightB;
    private double weightC;
    private double weightD;
    private double weightE;

    public TestScaleQuestion(int questionId, String questionTitle, String optionA, String optionB, String optionC, String optionD, String optionE, double weightA, double weightB, double weightC, double weightD, double weightE) {
        this.questionId = questionId;
        this.questionTitle = questionTitle;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.optionE = optionE;
        this.weightA = weightA;
        this.weightB = weightB;
        this.weightC = weightC;
        this.weightD = weightD;
        this.weightE = weightE;
    }

    public String getOptionE() {
        return optionE;
    }

    public void setOptionE(String optionE) {
        this.optionE = optionE;
    }

    public double getWeightE() {
        return weightE;
    }

    public void setWeightE(double weightE) {
        this.weightE = weightE;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public double getWeightA() {
        return weightA;
    }

    public void setWeightA(double weightA) {
        this.weightA = weightA;
    }

    public double getWeightB() {
        return weightB;
    }

    public void setWeightB(double weightB) {
        this.weightB = weightB;
    }

    public double getWeightC() {
        return weightC;
    }

    public void setWeightC(double weightC) {
        this.weightC = weightC;
    }

    public double getWeightD() {
        return weightD;
    }

    public void setWeightD(double weightD) {
        this.weightD = weightD;
    }
}
