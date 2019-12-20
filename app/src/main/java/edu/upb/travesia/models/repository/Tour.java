package edu.upb.travesia.models.repository;

import com.google.gson.annotations.Expose;

public class Tour {
    @Expose
    private String uuid;

    @Expose
    private String name;

    @Expose
    private Double price;

    @Expose
    private String picture;

    @Expose
    private String language;

    @Expose
    private String category;

    @Expose
    private int capacity;

    @Expose
    private String meetingPlace;

    @Expose
    private String description;

    @Expose
    private String tips;

    @Expose
    private String location;

    @Expose
    private String guide;

    @Expose
    private Duration duration;


    public Tour(String uuid, String name, Double price, String picture, String language, String category, int capacity, String meetingPlace, String description, String tips, String location, String guide, Duration duration) {
        this.uuid = uuid;
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.language = language;
        this.category = category;
        this.capacity = capacity;
        this.meetingPlace = meetingPlace;
        this.description = description;
        this.tips = tips;
        this.location = location;
        this.guide = guide;
        this.duration = duration;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getMeetingPlace() {
        return meetingPlace;
    }

    public void setMeetingPlace(String meetingPlace) {
        this.meetingPlace = meetingPlace;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public Tour getTour(){
        return this;
    }

}
