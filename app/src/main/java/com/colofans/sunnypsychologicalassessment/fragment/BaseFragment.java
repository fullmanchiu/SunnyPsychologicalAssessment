package com.colofans.sunnypsychologicalassessment.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.colofans.sunnypsychologicalassessment.MainActivity;


public class BaseFragment extends Fragment {
    protected MainActivity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
    }
}
