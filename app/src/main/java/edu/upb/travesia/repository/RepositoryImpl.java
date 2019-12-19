package edu.upb.travesia.repository;

import androidx.lifecycle.LiveData;

import edu.upb.travesia.models.repository.Base;
import edu.upb.travesia.models.repository.firebase.Bookings;
import edu.upb.travesia.models.ui.UserLogged;

public interface RepositoryImpl {
    LiveData<Base> login(String email, String password);

    LiveData<Base> getCountries();

    LiveData<Base> getCountryDetails(String uuid);

    LiveData<Base> insertBook(Bookings bookings);

    LiveData<Base> getBookings(UserLogged userLogged);

}
