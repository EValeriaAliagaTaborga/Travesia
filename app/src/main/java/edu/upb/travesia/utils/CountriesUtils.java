package edu.upb.travesia.utils;

import java.util.ArrayList;
import java.util.List;

import edu.upb.travesia.R;
import edu.upb.travesia.models.repository.Country;

public class CountriesUtils {
    public List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country(1, "Bolivia", R.drawable.ic_credit_card_blue_30dp));
        countries.add(new Country(2, "Francia", R.drawable.ic_credit_card_blue_30dp));
        countries.add(new Country(3, "Corea del Sur", R.drawable.ic_credit_card_blue_30dp));
        countries.add(new Country(4, "Alemania", R.drawable.ic_credit_card_blue_30dp));

        return countries;
    }
}
