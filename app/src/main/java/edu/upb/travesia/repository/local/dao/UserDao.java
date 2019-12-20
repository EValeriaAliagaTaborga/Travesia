package edu.upb.travesia.repository.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import edu.upb.travesia.models.repository.User;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(User user);

    @Query("DELETE FROM users_table")
    void deleteAll();

    @Query("SELECT * from users_table ORDER BY email ASC")
    LiveData<List<User>> getAll();

    @Query("SELECT * from users_table WHERE email = :email")
    LiveData<User> getUser(String email);

}
