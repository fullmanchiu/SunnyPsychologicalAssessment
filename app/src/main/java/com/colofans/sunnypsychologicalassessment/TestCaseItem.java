package com.colofans.sunnypsychologicalassessment;

import java.util.ArrayList;

/**
 * Created by Castor on 2016/5/9.
 */
public class TestCaseItem {
    private String subject;
    private ArrayList<String> options;

    public TestCaseItem(String subject, ArrayList<String> options) {
        this.subject = subject;
        this.options = options;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public String getSubject() {
        return subject;
    }

    public ArrayList<String> getOptions() {
        return options;
    }
}
