package com.colofans.sunnypsychologicalassessment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.colofans.sunnypsychologicalassessment.R;
import com.colofans.sunnypsychologicalassessment.db.TestService;
import com.colofans.sunnypsychologicalassessment.utils.IntentFactory;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends BaseFragment {
    private View view;
    private ListView listView;
    private ArrayList<String> data;
    TestService testService;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = View.inflate(activity, R.layout.fragment_test, null);
        listView = (ListView) view.findViewById(R.id.test_lv);
        testService = new TestService(activity);
        data = testService.getTableLabel();
        //data = getResources().getStringArray(R.array.test_case);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(IntentFactory.main2Test(activity, position));
            }
        });
        return view;
    }

}
