package edu.upb.travesia.repository;

import androidx.lifecycle.LiveData;

import edu.upb.travesia.models.repository.Base;

public interface RepositoryImpl {
    LiveData<Base> login(String email, String password);

    LiveData<Base> getCountries();

    LiveData<Base> getCountryDetails(String uuid);

}
