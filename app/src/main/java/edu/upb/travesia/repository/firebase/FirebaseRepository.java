package edu.upb.travesia.repository.firebase;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import edu.upb.travesia.models.repository.Base;
import edu.upb.travesia.models.repository.firebase.Book;
import edu.upb.travesia.models.repository.firebase.Bookings;
import edu.upb.travesia.models.repository.firebase.ObjectBasic;
import edu.upb.travesia.models.ui.UserLogged;

public class FirebaseRepository {
    private static FirebaseRepository instance;
    private FirebaseAuth auth;
    private FirebaseDatabase db;

    public static FirebaseRepository getInstance() {
        if (instance == null) {
            instance = new FirebaseRepository();
        }
        return instance;
    }

    private FirebaseRepository() {
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
    }

    public LiveData<Base> login(final String email, final String password) {
        final MutableLiveData<Base> results = new MutableLiveData<>();
        this.auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            results.postValue(new Base(user));
                        } else {
                            results.postValue(new Base("login Failure",
                                    new NullPointerException()));
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        results.postValue(new Base("login.onFailure", e));
                    }
                });
        return results;
    }

    public LiveData<Base> register(String email, String password) {
        final MutableLiveData<Base> results = new MutableLiveData<>();
        this.auth.createUserWithEmailAndPassword(email, password);
        return results;
    }

    public LiveData<Base> insertBook(Bookings bookings){
        final MutableLiveData<Base> result = new MutableLiveData<>();
        String[] name = bookings.getEmailUser().split("@");
        Log.e("Database", "inserting book");
        setValue("bookings/"+name[0],bookings);
        subscribeToValues("bookings");
        return result;
    }

    public LiveData<Base> getBookings(UserLogged userLogged) {
        String[] name = userLogged.getEmail().split("@");
        return subscribeToValues("bookings/"+name[0]);
    }

    public LiveData<Base> setValue(String path, Object value) {
        final MutableLiveData<Base> result = new MutableLiveData<>();
        Log.e("Database", "Value set: "+result.toString());
        db.getReference(path).setValue(value);
        return result;
    }

    public LiveData<Base> subscribeToValues(String path) {
        final MutableLiveData<Base> result = new MutableLiveData<>();
        db.getReference(path).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String values = new Gson().toJson(dataSnapshot.getValue());
                Log.e("Database", values);

                result.postValue(new Base(values));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return result;
    }

}
