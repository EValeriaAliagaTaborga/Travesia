package edu.upb.travesia.models.repository.firebase;


public class Book {
    private Boolean confirmed;
    private String tourTitle;
    private Double tourPrice;
    private String tourImg;
    private String date;
    private int quantity;

    public Book(Boolean confirmed, String tourTitle, Double tourPrice, String date, int quantity, String tourImg) {
        this.confirmed = confirmed;
        this.tourTitle = tourTitle;
        this.tourPrice = tourPrice;
        this.date = date;
        this.quantity = quantity;
        this.tourImg = tourImg;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getTourTitle() {
        return tourTitle;
    }

    public void setTourTitle(String tourTitle) {
        this.tourTitle = tourTitle;
    }

    public Double getTourPrice() {
        return tourPrice;
    }

    public void setTourPrice(Double tourPrice) {
        this.tourPrice = tourPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTourImg() {
        return tourImg;
    }

    public void setTourImg(String tourImg) {
        this.tourImg = tourImg;
    }
}

