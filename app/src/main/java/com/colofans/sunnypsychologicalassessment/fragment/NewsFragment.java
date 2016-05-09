package com.colofans.sunnypsychologicalassessment.fragment;


import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.colofans.sunnypsychologicalassessment.R;
import com.colofans.sunnypsychologicalassessment.beans.News;
import com.colofans.sunnypsychologicalassessment.utils.IntentFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment {
    private View view;
    private ListView listView;
    private ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
    private String[] newsTitle;//={"Title1","Title2","Title3","Title4","Title5","Title6"};
    private String[] newsSummary;//={"Summary1","Summary2","Summary3","Summary4","Summary5","Summary6"};
    private int[] img;//= {R.drawable.default_img,R.drawable.default_img,R.drawable.default_img,R.drawable.default_img,R.drawable.default_img,R.drawable.default_img};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = View.inflate(activity,R.layout.fragment_news,null);
        initViews();
        return view;
    }

    private void initViews() {
        listView = (ListView) view.findViewById(R.id.news_lv);
        newsTitle = getResources().getStringArray(R.array.news_title);
        newsSummary = getResources().getStringArray(R.array.news_summary);
        TypedArray array = getResources().obtainTypedArray(R.array.news_img);
        int len = array.length();
        img = new int[len];
        for (int i = 0; i < len; i++)
            img[i] = array.getResourceId(i, 0);
        array.recycle();
        for (int i = 0; i < newsTitle.length; i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("title", newsTitle[i]);
            item.put("summary", newsSummary[i]);
            item.put("img", img[i]);
            data.add(item);
        }
        listView.setAdapter(
                new SimpleAdapter(
                        getActivity(), data, R.layout.news_item,
                        new String[]{"title", "summary", "img"},
                        new int[]{R.id.news_lv_item_title, R.id.news_lv_item_sumarry,
                                R.id.news_lv_item_img}));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                News news = new News(newsTitle[position], newsSummary[position], img[position]);
                startActivity(IntentFactory.main2News(activity, news));
            }
        });
    }

}
