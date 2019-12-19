package edu.upb.travesia.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;

import edu.upb.travesia.models.repository.Base;
import edu.upb.travesia.models.repository.firebase.Bookings;
import edu.upb.travesia.models.ui.UserLogged;
import edu.upb.travesia.repository.api.ApiRespository;
import edu.upb.travesia.repository.firebase.FirebaseRepository;

public class Repository implements RepositoryImpl {
    private static Repository instance;

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    private Repository() {
    }

    @Override
    public LiveData<Base> login(String email, String password) {
        return FirebaseRepository.getInstance().login(email, password);
        //return null;
    }

    @Override
    public LiveData<Base> getCountries() {
        return ApiRespository.getInstance().getCountries();
        //return null;
    }

    @Override
    public LiveData<Base> getCountryDetails(String uuid) {
        return null;
    }


    @Override
    public LiveData<Base> insertBook(Bookings bookings) {
        Log.e("Database", "Insert book on Repository");
        return FirebaseRepository.getInstance().insertBook(bookings);
    }

    @Override
    public LiveData<Base> getBookings(UserLogged userLogged){
        return FirebaseRepository.getInstance().getBookings(userLogged);
    }
}
