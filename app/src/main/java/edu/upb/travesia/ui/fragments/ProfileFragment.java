package edu.upb.travesia.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.upb.travesia.R;

public class ProfileFragment extends BaseFragment {

    public ProfileFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        //initUI(view);
        return view;
    }

    /*private void initUI(View view) {
        //myTextTextView = view.findViewById(R.id.myTextTextView);
    }*/

}
