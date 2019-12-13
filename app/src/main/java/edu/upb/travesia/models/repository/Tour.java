package edu.upb.travesia.models.repository;

import com.google.gson.annotations.Expose;

public class Tour {
    @Expose
    private String uuid;

    @Expose
    private String name;

    @Expose
    private double price;

    @Expose
    private String picture;


    public Tour(String uuid, String name, double price, String picture) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
        this.picture = picture;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Tour geTour(){
        return this;
    }

}
