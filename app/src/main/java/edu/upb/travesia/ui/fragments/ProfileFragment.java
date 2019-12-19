package edu.upb.travesia.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.upb.travesia.R;
import edu.upb.travesia.models.ui.UserLogged;

public class ProfileFragment extends BaseFragment {

    private TextView email;
    private TextView type;
    private UserLogged userLogged;

    public ProfileFragment(UserLogged userLogged) {
        this.userLogged = userLogged;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initUI(view);
        return view;
    }

    private void initUI(View view) {
        email = view.findViewById(R.id.lblProfile);
        type = view.findViewById(R.id.lblTypeProfile);
        email.setText(userLogged.getEmail());
        type.setText(userLogged.getType().toString());
    }

}
