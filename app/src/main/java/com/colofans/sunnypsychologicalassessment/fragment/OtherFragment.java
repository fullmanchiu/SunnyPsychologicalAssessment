package com.colofans.sunnypsychologicalassessment.fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.colofans.sunnypsychologicalassessment.R;
import com.colofans.sunnypsychologicalassessment.beans.TestRecord;
import com.colofans.sunnypsychologicalassessment.db.TestRecordService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherFragment extends BaseFragment {
    private View view;
    private ListView listView;
    private TextView textView;
    private List<TestRecord> records;
    List<Map<String, Object>> recordData;
    TestRecordService testRecordService;
    SimpleAdapter adpter;
    private int index = 0;
    public OtherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = View.inflate(activity, R.layout.fragment_other, null);
        listView = (ListView) view.findViewById(R.id.fragment_other_lv);
        textView = (TextView) view.findViewById(R.id.fragment_other_tv);
        recordData = getData();
        adpter = new SimpleAdapter(activity, recordData, R.layout.lv_record, new String[]{"name", "score", "summary"}, new int[]{R.id.lv_record_name, R.id.lv_record_score, R.id.lv_record_summary});
        listView.setAdapter(adpter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                index = (int) getData().get(position).get("id");
                Log.i("Lance", "index:" + index);
                new AlertDialog.Builder(activity).setTitle("XXXX").setItems(new String[]{"delete"}, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        deleteItem(index);
                    }
                }).show();
                return false;
            }
        });
        return view;
    }

    private void deleteItem(int id) {
        testRecordService.delete(id);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.ReflashList");
        activity.sendBroadcast(intent);
    }


    public List<Map<String, Object>> getData() {
        List<Map<String, Object>> tempData = new ArrayList<>();
        testRecordService = new TestRecordService(getActivity());
        records = new ArrayList<>();
        records = testRecordService.getRecordList();
        Map<String, Object> map;
        if (records != null) {
            for (TestRecord record : records) {
                Log.i("Lance", "getRecordList records:" + record.toString());
                map = new HashMap<>();
                map.put("id", record.getId());
                map.put("name", record.getName());
                map.put("score", record.getScore());
                map.put("summary", record.getSummary());
                tempData.add(map);
            }
        }
        if (tempData.size() > 0) {
            textView.setVisibility(View.INVISIBLE);
            listView.setVisibility(View.VISIBLE);
        }
        return tempData;
    }
}
