package edu.upb.travesia.repository.mock;

import android.util.Log;

import java.util.HashMap;

import edu.upb.travesia.utils.RatingUtils;

public class RatingMockRepository {
    private static RatingMockRepository instance;

    public static RatingMockRepository getInstance() {
        if (instance == null) {
            instance = new RatingMockRepository();
        }
        return instance;
    }

    public Integer getRating(String tourGuide){
        Log.e("Rating","RatingMockRepo");
        return RatingUtils.getGuidesRatings().get(tourGuide);
    }

}


