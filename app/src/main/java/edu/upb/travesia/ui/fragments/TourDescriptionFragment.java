package edu.upb.travesia.ui.fragments;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.lifecycle.Observer;

import com.google.gson.Gson;

import java.util.HashMap;

import edu.upb.travesia.R;
import edu.upb.travesia.models.repository.Base;
import edu.upb.travesia.models.repository.Tour;
import edu.upb.travesia.models.ui.UserLogged;
import edu.upb.travesia.utils.RatingUtils;

public class TourDescriptionFragment extends BaseFragment{

    private TextView lblTitle;
    private ImageView imgTour;
    private TextView lblPrice;
    private Button btnBook;
    private TextView lblLanguages;
    private TextView lblDurationStart;
    private TextView lblDurationEnd;
    private TextView lblDurationDays;
    private TextView lblCategories;
    private TextView lblCapacity;
    private TextView lblMeetingPoint;
    private TextView lblDescription;
    private TextView lblTips;
    private ImageView imgLocation;
    private TextView lblGuide;
    private RatingBar ratingGuide;

    private Gson gson = new Gson();
    private Tour tour;

    private UserLogged userLogged;

    private Integer rate;

    public TourDescriptionFragment(Tour tour, UserLogged userLogged) {
        this.tour = tour;
        this.userLogged = userLogged;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tour_description, container, false);

        initViews(view);
        fillData();

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*count = System.currentTimeMillis();
                User user = new User();
                user.setUuid("user-" + count);
                user.setEmail(count + "_temp@pumatiti.com");
                user.setPassword("123456");
                viewModel.register(user);*/
                Log.e("btnBook","Click");
                changeFragment(new BookFragment(tour,userLogged));

            }
        });

        return view;

    }

    private void fillData() {
        lblTitle.setText(tour.getName());
        imgTour.setImageURI(Uri.parse("android.resource://edu.upb.travesia/drawable/"+tour.getPicture()));
        lblPrice.setText(tour.getPrice()+"");
        lblLanguages.setText(tour.getLanguage());
        lblDurationStart.setText(tour.getDuration().getStart());
        lblDurationEnd.setText(tour.getDuration().getEnd());
        lblDurationDays.setText(tour.getDuration().getDays());
        lblCategories.setText(tour.getCategory());
        lblCapacity.setText(tour.getCapacity()+"");
        lblMeetingPoint.setText(tour.getMeetingPlace());
        lblDescription.setText(tour.getDescription());
        lblTips.setText(tour.getTips());
        lblGuide.setText(tour.getGuide());
        imgLocation.setImageURI(Uri.parse("android.resource://edu.upb.travesia/drawable/"+tour.getLocation()));
        rate = viewModel.getRatings(tour.getGuide());
        if(rate == null){
            Log.e("Rate","Nuuuuuuullllll");
            ratingGuide.setRating(0);
        } else {
            ratingGuide.setRating(rate);
        }

    }


    private void initViews(View view) {
        lblTitle = view.findViewById(R.id.lblTourTitle);
        imgTour = view.findViewById(R.id.imgTour);
        lblPrice = view.findViewById(R.id.lblPrice);
        btnBook = view.findViewById(R.id.btnBook);
        lblLanguages = view.findViewById(R.id.lblLanguages);
        lblDurationStart = view.findViewById(R.id.lblDurationStart);
        lblDurationEnd = view.findViewById(R.id.lblDurationEnd);
        lblDurationDays = view.findViewById(R.id.lblDurationDays);
        lblCategories = view.findViewById(R.id.lblCategories);
        lblCapacity = view.findViewById(R.id.lblCapacity);
        lblMeetingPoint = view.findViewById(R.id.lblMeetingPoint);
        lblDescription = view.findViewById(R.id.lblDescription);
        lblTips = view.findViewById(R.id.lblTips);
        lblGuide = view.findViewById(R.id.lblGuide);
        imgLocation = view.findViewById(R.id.imgLocation);
        ratingGuide = view.findViewById(R.id.rating);
    }



}
