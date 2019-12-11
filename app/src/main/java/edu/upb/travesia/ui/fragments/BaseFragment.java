package edu.upb.travesia.ui.fragments;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import edu.upb.travesia.R;

public class BaseFragment extends Fragment {


    public void changeFragment(Fragment fragment) {
        Fragment newFragment = fragment;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.containerFrameLayout, newFragment);
        transaction.addToBackStack(null);

        // Commit a la transacción
        transaction.commit();
    }
}
