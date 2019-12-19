package edu.upb.travesia.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import edu.upb.travesia.models.repository.Base;
import edu.upb.travesia.models.repository.firebase.Bookings;
import edu.upb.travesia.models.ui.UserLogged;
import edu.upb.travesia.repository.MockRepository;
import edu.upb.travesia.repository.Repository;
import edu.upb.travesia.repository.RepositoryImpl;

public class MainViewModel extends AndroidViewModel {

    private RepositoryImpl repository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance();
        //repository = MockRepository.getInstance();
    }

    public LiveData<Base> getCountries() {
        return repository.getCountries();
    }

    public LiveData<Base> insertBook(Bookings bookings){
        Log.e("Database", "Insert book on view model");
        return repository.insertBook(bookings);
    }

    public LiveData<Base> getBookings(UserLogged userLogged){
        return repository.getBookings(userLogged);
    }

    public Integer getRatings(String tourGuide){
        Log.e("Rating","MainViewModel");
        return repository.getRatings(tourGuide);
    }


}
