package edu.upb.travesia.utils;

import java.util.ArrayList;
import java.util.List;

import edu.upb.travesia.models.repository.City;

public class CitiesUtils {
    public List<City> getCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City(1, "La Paz"));
        cities.add(new City(2, "Cochabamba"));
        cities.add(new City(3, "Santa Cruz"));
        cities.add(new City(4, "Tarija"));
        cities.add(new City(5, "Sucre"));
        cities.add(new City(6, "Potosí"));

        return cities;
    }
}
