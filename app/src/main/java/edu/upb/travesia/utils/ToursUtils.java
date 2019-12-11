package edu.upb.travesia.utils;

import java.util.ArrayList;
import java.util.List;

import edu.upb.travesia.R;
import edu.upb.travesia.models.repository.Tour;

public class ToursUtils {
    public List<Tour> getTours() {
        List<Tour> tours = new ArrayList<>();
        tours.add(new Tour(1,"Teleferico", R.drawable.cable_car,50));
        tours.add(new Tour(2,"ElectroPreste", R.drawable.electropreste,300));
        tours.add(new Tour(3,"Tour 3", R.drawable.default_image,20.5)); //no da la default

        return tours;
    }
}
