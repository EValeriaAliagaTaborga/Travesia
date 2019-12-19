package edu.upb.travesia.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.upb.travesia.R;
import edu.upb.travesia.models.ui.UserLogged;

public class MoreFragment extends BaseFragment {

    private UserLogged userLogged;

    public MoreFragment(UserLogged userLogged) {
        this.userLogged = userLogged;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        //initUI(view);
        return view;
    }

    /*private void initUI(View view) {
        //myTextTextView = view.findViewById(R.id.myTextTextView);
    }*/

}
