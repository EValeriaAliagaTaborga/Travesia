package edu.upb.travesia.repository;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.upb.travesia.models.repository.Base;
import edu.upb.travesia.models.repository.User;

public interface RepositoryImpl {
    LiveData<Base> login(String email, String password);

    LiveData<Base> getCountries();

    LiveData<Base> getCountryDetails(String uuid);


    //Db
    void insert(User user);

    LiveData<List<User>> getAll();

    LiveData<Base> register(String email, String password);

}
