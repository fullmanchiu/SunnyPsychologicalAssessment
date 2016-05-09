package com.colofans.sunnypsychologicalassessment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.colofans.sunnypsychologicalassessment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultFragment extends BaseFragment {
    private View view;
    private LinearLayout llAddress, llTel, llEmail, llQQ, llWechat;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = View.inflate(activity, R.layout.fragment_consult, null);
        initViews();
        return view;
    }

    private void initViews() {
        llAddress = (LinearLayout) view.findViewById(R.id.consult_ll_address);
        llTel = (LinearLayout) view.findViewById(R.id.consult_ll_tel);
        llEmail = (LinearLayout) view.findViewById(R.id.consult_ll_email);
        llQQ = (LinearLayout) view.findViewById(R.id.consult_ll_qq);
        llWechat = (LinearLayout) view.findViewById(R.id.consult_ll_wechat);

    }

}
