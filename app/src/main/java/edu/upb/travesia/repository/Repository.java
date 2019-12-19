package edu.upb.travesia.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import edu.upb.travesia.models.repository.Base;
import edu.upb.travesia.models.repository.User;
import edu.upb.travesia.repository.api.ApiRespository;
import edu.upb.travesia.repository.firebase.FirebaseRepository;
import edu.upb.travesia.repository.local.LocalRepository;

public class Repository implements RepositoryImpl {
    private static Repository instance;
    private LocalRepository local;

    public static Repository getInstance(Application application) {
        if (instance == null) {
            instance = new Repository(application);
        }
        return instance;
    }

    private Repository(Application application) {
        local = new LocalRepository(application);
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
    public void insert(User user) {
        local.insert(user);
    }

    @Override
    public LiveData<List<User>> getAll() {
        return local.getAll();
    }

}
