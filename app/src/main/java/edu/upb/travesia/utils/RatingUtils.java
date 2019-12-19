package edu.upb.travesia.utils;

import android.util.Log;

import java.util.HashMap;

public class RatingUtils {

    // Create a HashMap object called guidesRatings

    // Add keys and values (Country, City)
    public static HashMap<String,Integer> getGuidesRatings() {
        HashMap<String, Integer> guidesRatings = new HashMap<String, Integer>();
        guidesRatings.put("Taylor the Guide Bird", 5);
        guidesRatings.put("Trevor the Safety Pup", 4);
        guidesRatings.put("Teresa the Fashion Butterfly", 2);
        guidesRatings.put("Trent the Friendly Chameleon", 4);
        guidesRatings.put("Tiana the Princess Frog", 3);
        Log.e("Rating","RatingUtils");
        return guidesRatings;
    }



    /*
    public static List<Guide> getRatings(){
        List<Guide> guidesRatings = new ArrayList<>();
        guidesRatings.add(new Guide(1,"Taylor The Guide Bird",5));
        guidesRatings.add(new Guide(2,"Trevor The Safety Pup",4));
        guidesRatings.add(new Guide(3,"Teresa The Fashion Butterfly",2));
        guidesRatings.add(new Guide(4,"Trent The Friendly Chameleon",4));
        guidesRatings.add(new Guide(5,"Tiana The Princess Frog",3));
        return guidesRatings;
    }*/

}
