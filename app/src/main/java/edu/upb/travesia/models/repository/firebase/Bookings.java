package edu.upb.travesia.models.repository.firebase;

import java.util.List;


public class Bookings {

    private String emailUser;
    private List<Book> bookings;

    public Bookings(String emailUser, List<Book> bookings) {
        this.emailUser = emailUser;
        this.bookings = bookings;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public List<Book> getBookings() {
        return bookings;
    }

    public void setBookings(List<Book> bookings) {
        this.bookings = bookings;
    }
}
