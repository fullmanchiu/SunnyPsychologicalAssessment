package com.colofans.sunnypsychologicalassessment;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Castor on 2016/5/9.
 */
public class TestCase implements Serializable {
    private String length;
    private String testTitle;
    private ArrayList<TestCaseItem> testCaseItems;

    public TestCase(String length) {
        this.length = length;
    }

    public String getLength() {
        return length;
    }

    public TestCase(String testTitle, ArrayList<TestCaseItem> testCaseItems, String length) {
        this.testTitle = testTitle;
        this.testCaseItems = testCaseItems;
    }

    public String getTestTitle() {
        return testTitle;
    }

    public void setTestTitle(String testTitle) {
        this.testTitle = testTitle;
    }

    public ArrayList<TestCaseItem> getTestCaseItems() {
        return testCaseItems;
    }

    public void setTestCaseItems(ArrayList<TestCaseItem> testCaseItems) {
        this.testCaseItems = testCaseItems;
    }
}
