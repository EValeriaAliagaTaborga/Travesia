package edu.upb.travesia.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import edu.upb.travesia.models.repository.Base;
import edu.upb.travesia.models.repository.User;
import edu.upb.travesia.repository.Repository;
import edu.upb.travesia.repository.RepositoryImpl;

public class RegisterViewModel extends AndroidViewModel {
    private RepositoryImpl repository;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(application);
    }

    public LiveData<Base> register(final User user) {
        final MutableLiveData<Base> result = new MutableLiveData<>();
        repository.insert(user);
        repository.register(user.getEmail(),user.getPassword());
        return result;
    }

    public LiveData<List<User>> getAll() {
        return repository.getAll();
    }

}
