package edu.upb.travesia.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import edu.upb.travesia.R;

public class MoreFragment extends BaseFragment {

    public MoreFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        //initUI(view);

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        return view;
    }

    /*private void initUI(View view) {
        //myTextTextView = view.findViewById(R.id.myTextTextView);
    }*/

}
