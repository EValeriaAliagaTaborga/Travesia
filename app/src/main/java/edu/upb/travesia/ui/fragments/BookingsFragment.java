package edu.upb.travesia.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import com.google.gson.Gson;

import java.util.List;

import edu.upb.travesia.R;
import edu.upb.travesia.models.repository.Base;
import edu.upb.travesia.models.repository.firebase.Book;
import edu.upb.travesia.models.repository.firebase.Booking;
import edu.upb.travesia.models.ui.UserLogged;

public class BookingsFragment extends BaseFragment {

    private UserLogged userLogged;
    private TextView lblTitle;

    private List<Booking> bookings;

    public BookingsFragment(UserLogged userLogged) {
        this.userLogged = userLogged;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookings, container, false);
        initUI(view);

        //Log.e("Booking",viewModel.getBookings(userLogged).getValue().toString());



        //lblTitle.setText(bookings.get(0).getEmailUser());
        return view;
    }

    private void initUI(View view) {
        lblTitle = view.findViewById(R.id.lblBookings);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.getBookings(userLogged).observe(this, new Observer<Base>() {
            @Override
            public void onChanged(Base base) {
                if(base.isSuccess()){
                    //Log.e("Datos",new Gson().toJson(base.getData()));
                    bookings = (List<Booking>) base.getData();
                    for(int i = 0; i < bookings.size();i++){
                        Log.e("Datos",bookings.get(i).getBookings().get(0).getTourTitle());
                    }
                }
            }
        });
    }

}
