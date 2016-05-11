package com.colofans.sunnypsychologicalassessment.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.colofans.sunnypsychologicalassessment.MainActivity;
import com.colofans.sunnypsychologicalassessment.NewsActivity;
import com.colofans.sunnypsychologicalassessment.TestNoticeActivity;
import com.colofans.sunnypsychologicalassessment.TestScale;
import com.colofans.sunnypsychologicalassessment.beans.News;

/**
 * Created by fullm on 2016/5/8.
 */
public class IntentFactory {
    private static Intent intent;
    public static Intent splash2Main(Context context) {
        intent =  new Intent();
        intent.setClass(context, MainActivity.class);
        return intent;
    }

    public static Intent main2News(Context context, News news) {
        intent = new Intent();
        intent.setClass(context, NewsActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("news", news);
        intent.putExtras(bundle);
        return intent;
    }

    public static Intent main2Test(Context context, int testCase) {
        intent = new Intent();
        intent.setClass(context, TestNoticeActivity.class);
        intent.putExtra("testCase", testCase);
        return intent;
    }

    public static Intent testNotice2Test(Context context, TestScale testScale) {
        intent = new Intent();
        intent.setClass(context, TestNoticeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("testScale", testScale);
        intent.putExtras(bundle);
        return intent;
    }
}
