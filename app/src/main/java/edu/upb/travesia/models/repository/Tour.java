package edu.upb.travesia.models.repository;

import com.google.gson.annotations.Expose;

public class Tour {
    @Expose
    private int id;

    @Expose
    private String name;

    @Expose
    private int image;

    @Expose
    private double price;

    public Tour(int id, String name, int image, double price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Tour geTour(){
        return this;
    }

}
