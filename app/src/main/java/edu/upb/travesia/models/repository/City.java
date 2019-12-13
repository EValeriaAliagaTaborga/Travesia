package edu.upb.travesia.models.repository;

import com.google.gson.annotations.Expose;

import java.util.List;

public class City {
    @Expose
    private String uuid;

    @Expose
    private String name;

    @Expose
    private List<Tour> tours;

    public City(String uuid, String name, List<Tour> tours) {
        this.uuid = uuid;
        this.name = name;
        this.tours = tours;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tour> getTours() {
        return tours;
    }

    public void setTours(List<Tour> tours) {
        this.tours = tours;
    }

    public City getCity(){
        return this;
    }

}
