package edu.upb.travesia.repository.local.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import edu.upb.travesia.models.repository.User;
import edu.upb.travesia.repository.local.dao.UserDao;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class TravesiaDB extends RoomDatabase {

    public abstract UserDao userDao();

    private static volatile TravesiaDB INSTANCE;

    static public TravesiaDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TravesiaDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TravesiaDB.class, "travesia_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
