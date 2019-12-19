package edu.upb.travesia.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.google.firebase.auth.FirebaseUser;

import edu.upb.travesia.models.repository.Base;
import edu.upb.travesia.models.ui.UserLogged;
import edu.upb.travesia.repository.Repository;
import edu.upb.travesia.utils.ResponseMapper;

public class LoginViewModel extends AndroidViewModel {

    private Repository repository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        repository = Repository.getInstance(application);
    }

    public LiveData<Base> login(final String email, final String password) {
        final MutableLiveData<Base> result = new MutableLiveData<>();
        repository.login(email, password).observeForever(new Observer<Base>() {
            @Override
            public void onChanged(Base base) {
                if (base.isSuccess()) {
                    FirebaseUser user = (FirebaseUser) base.getData();
                    UserLogged userLogged = ResponseMapper.mapUserToUserLooged(user);
                    result.postValue(new Base(userLogged));
                } else {
                    result.postValue(base);
                }
            }
        });
        return result;
    }
}
