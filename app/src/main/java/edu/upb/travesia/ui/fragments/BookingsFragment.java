package edu.upb.travesia.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.util.List;

import edu.upb.travesia.R;
import edu.upb.travesia.models.repository.Base;
import edu.upb.travesia.models.repository.firebase.Book;
import edu.upb.travesia.models.repository.firebase.Bookings;
import edu.upb.travesia.models.ui.UserLogged;

public class BookingsFragment extends BaseFragment {

    private UserLogged userLogged;
    private TextView lblTitle;

    private List<Book> bookings;
    private FirebaseDatabase db;

    public BookingsFragment(UserLogged userLogged) {
        this.userLogged = userLogged;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookings, container, false);
        initUI(view);
        db = FirebaseDatabase.getInstance();
        //Log.e("Bookings",viewModel.getBookings(userLogged).getValue().toString());

        db.getReference("bookings/travis/bookings").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String values = new Gson().toJson(dataSnapshot.getValue());
                //Log.e("Database", values);
                bookings = (List<Book>) dataSnapshot.getValue();
                Log.e("Database Bookings", bookings.toString());

                //Log.e("Database Bookings", bookings.get(0).getTourTitle());
                lblTitle.setText(bookings.toString());
                /*for (DataSnapshot msgSnapshot : snapshot.getChildren()) {
                    Productos msg = msgSnapshot.getValue(Productos.class);
                    productosAdapter.add(msg);
                } */
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

            //lblTitle.setText(bookings.get(0).getEmailUser());
        return view;
    }

    private void initUI(View view) {
        lblTitle = view.findViewById(R.id.lblBookings);
    }



}
