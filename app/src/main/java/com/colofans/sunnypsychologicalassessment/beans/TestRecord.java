package com.colofans.sunnypsychologicalassessment.beans;

/**
 * Created by Castor on 2016/5/19.
 */
public class TestRecord {
    private String name;
    private String score;
    private String summary;
    private int id;
    public static final String RECORD_ID = "id";
    public static final String RECORD_NAME = "name";
    public static final String RECORD_SCORE = "score";
    public static final String RECORD_SUMMARY = "summary";

    public TestRecord(String name, String score, String summary) {
        this.name = name;
        this.score = score;
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TestRecord{" +
                "name='" + name + '\'' +
                ", score='" + score + '\'' +
                ", summary='" + summary + '\'' +
                ", id=" + id +
                '}';
    }
}
