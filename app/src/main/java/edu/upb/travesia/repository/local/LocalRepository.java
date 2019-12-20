package edu.upb.travesia.repository.local;

import android.app.Application;


import androidx.lifecycle.LiveData;

import java.util.List;

import edu.upb.travesia.models.repository.User;
import edu.upb.travesia.repository.local.db.TravesiaDB;

public class LocalRepository {
    private TravesiaDB db;


    public LocalRepository(Application application) {
        db = TravesiaDB.getDatabase(application);
    }

    public void insert(final User user) {
        Thread thread = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        db.userDao().insert(user);
                    }
                }
        );
        thread.start();
    }

    public LiveData<List<User>> getAll() {
        return db.userDao().getAll();
    }
}
