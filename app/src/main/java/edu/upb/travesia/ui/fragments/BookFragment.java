package edu.upb.travesia.ui.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import edu.upb.travesia.R;
import edu.upb.travesia.models.repository.Tour;
import edu.upb.travesia.models.repository.firebase.Book;
import edu.upb.travesia.models.repository.firebase.Booking;
import edu.upb.travesia.models.ui.UserLogged;

public class BookFragment extends BaseFragment {

    private TextView lblTitle;
    private Button btnSendBook;
    private EditText txtDate;
    private EditText txtQuantity;

    private ProgressDialog loadingDialog;

    private Gson gson = new Gson();
    private Tour tour;

    private UserLogged userLogged;

    public BookFragment(Tour tour, UserLogged userLogged) {
        this.tour = tour;
        this.userLogged = userLogged;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        initViews(view);


        lblTitle.setText(tour.getName());

        btnSendBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*count = System.currentTimeMillis();
                User user = new User();
                user.setUuid("user-" + count);
                user.setEmail(count + "_temp@pumatiti.com");
                user.setPassword("123456");
                viewModel.register(user);*/
                Log.e("btnSendBook",userLogged.getEmail());
                chargeProgressBarPinner();
                //changeFragment();

            }
        });

        return view;

    }

    private void book(boolean confirmed) {
        List<Book> books = new ArrayList<>();
        //books.add(new Book(confirmed, tour.getName(),tour.getPrice(),"25/12/2019",3));
        String date = "01/01/2020";
        int quantity = 1;
        if(!txtDate.getText().toString().isEmpty()) {
            date = txtDate.getText().toString();
        }
        if(!txtQuantity.getText().toString().isEmpty()){
            quantity = Integer.parseInt(txtQuantity.getText().toString());
        }

        books.add(new Book(confirmed, tour.getName(),tour.getPrice(),date,quantity,tour.getPicture()));
        Booking booking = new Booking(userLogged.getEmail(),books);
        Log.e("Database", "Insert book on fragment");
        viewModel.insertBook(booking);
    }

    private void chargeProgressBarPinner() {
        book(false);
        showLoading();
        Log.e("loading", "show loading");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    book(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dismissLoading();
            }
        }).start();
    }


    private void initViews(View view) {
        lblTitle = view.findViewById(R.id.lblTourTitleBook);
        btnSendBook = view.findViewById(R.id.btnSendBook);
        txtDate = view.findViewById(R.id.txtDateBook);
        txtQuantity = view.findViewById(R.id.txtQuantityBook);

    }

    private void showLoading() {
        loadingDialog = new ProgressDialog(context);
        loadingDialog.setMessage("Loading");
        loadingDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        //loadingDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        loadingDialog.setMax(100);
        loadingDialog.setProgress(0);
        loadingDialog.show();
    }


    private void dismissLoading() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();

        }
    }

}



