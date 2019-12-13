package edu.upb.travesia.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import edu.upb.travesia.R;
import edu.upb.travesia.models.ui.UserLogged;
import edu.upb.travesia.ui.activities.MainActivity;
import edu.upb.travesia.viewmodel.MainViewModel;

public class BaseFragment extends Fragment {

    //protected UserLogged userLogged;

    protected MainViewModel viewModel;
    protected MainActivity activity;
    protected Context context;

    /*public BaseFragment(UserLogged userLogged) {
        this.userLogged = userLogged;
    }*/
    public BaseFragment() {

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof MainActivity) {
            this.activity = (MainActivity) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.context = null;
    }


    public void changeFragment(Fragment fragment) {
        Fragment newFragment = fragment;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.containerFrameLayout, newFragment);
        transaction.addToBackStack(null);

        // Commit a la transacción
        transaction.commit();
    }
}
