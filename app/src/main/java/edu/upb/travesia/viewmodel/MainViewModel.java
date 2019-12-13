package edu.upb.travesia.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import edu.upb.travesia.models.repository.Base;
import edu.upb.travesia.repository.MockRepository;
import edu.upb.travesia.repository.Repository;
import edu.upb.travesia.repository.RepositoryImpl;

public class MainViewModel extends AndroidViewModel {

    private RepositoryImpl repository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        //repository = Repository.getInstance();
        repository = MockRepository.getInstance();
    }

    public LiveData<Base> getCountries() {
        return repository.getCountries();
    }
}
