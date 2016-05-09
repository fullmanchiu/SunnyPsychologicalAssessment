package com.colofans.sunnypsychologicalassessment.beans;

import java.io.Serializable;

/**
 * Created by Castor on 2016/5/9.
 */
public class News implements Serializable {
    private String newsTitle;
    private String newsSummary;
    private int newsImg;

    public News(String newsTitle, String newsSummary, int newsImg) {
        this.newsTitle = newsTitle;
        this.newsSummary = newsSummary;
        this.newsImg = newsImg;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public String getNewsSummary() {
        return newsSummary;
    }

    public int getNewsImg() {
        return newsImg;
    }
}
