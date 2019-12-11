package edu.upb.travesia.models.repository;

import com.google.gson.annotations.Expose;

public class Country {
    @Expose
    private int id;

    @Expose
    private String name;

    @Expose
    private int image;


    public Country(int id, String name, int image) {
        this.id = id;
        this.name = name;
        this.image = image;
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

    public Country getCountry(){
        return this;
    }

}
