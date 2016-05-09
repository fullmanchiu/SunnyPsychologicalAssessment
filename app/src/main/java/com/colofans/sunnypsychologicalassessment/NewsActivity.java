package com.colofans.sunnypsychologicalassessment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.colofans.sunnypsychologicalassessment.beans.News;

public class NewsActivity extends AppCompatActivity {
    private News news;
    private ImageView iv;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Intent intent = this.getIntent();
        news = (News) intent.getSerializableExtra("news");
        initViews();

        setTitle(news.getNewsTitle());
    }

    private void initViews() {
        iv = (ImageView) findViewById(R.id.activity_news_img);
        tv = (TextView) findViewById(R.id.activity_news_tv);
        Drawable drawable = getResources().getDrawable(news.getNewsImg());
        iv.setBackground(drawable);
        tv.setText(news.getNewsSummary());
    }
}
