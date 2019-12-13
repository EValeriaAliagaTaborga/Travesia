package edu.upb.travesia.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import edu.upb.travesia.R;
import edu.upb.travesia.models.ui.UserLogged;
import edu.upb.travesia.ui.fragments.BookingsFragment;
import edu.upb.travesia.ui.fragments.CountriesListFragment;
import edu.upb.travesia.ui.fragments.ExploreFragment;
import edu.upb.travesia.ui.fragments.MoreFragment;
import edu.upb.travesia.ui.fragments.OnTourFragment;
import edu.upb.travesia.ui.fragments.ProfileFragment;
import edu.upb.travesia.utils.Constants;

public class MainActivity extends AppCompatActivity {


    private UserLogged userLogged;


    private BottomNavigationView navigationView;
    private Map<String, Fragment> mapFragments = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        getUserInfo();

        configureNavigationEvents();
        initFragments();
        loadFragment(Constants.KEY_FRAGMENT_PROFILE);

        Intent intent = getIntent();
        if (intent.hasExtra("message")) {
            String message = intent.getStringExtra("message");
            Toast.makeText(this, // Context, origen
                    message, //Mensaje
                    Toast.LENGTH_SHORT) //Duración
                    .show();
        }

    }

   private void initUI() {
        navigationView = findViewById(R.id.bottomNavigation);
    }

    private void getUserInfo() {
        Intent intent = getIntent();
        if (intent.hasExtra(Constants.INTENT_KEY_USER_LOGGED)) {
            String json = intent.getStringExtra(Constants.INTENT_KEY_USER_LOGGED);
            try {
                userLogged = new Gson().fromJson(json, UserLogged.class);
            } catch (Exception ex) {

            }
        }
    }


    private void configureNavigationEvents() {
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.action_profile:
                        loadFragment(Constants.KEY_FRAGMENT_PROFILE);
                        break;
                    case R.id.action_bookings:
                        loadFragment(Constants.KEY_FRAGMENT_BOOKINGS);
                        break;
                    case R.id.action_explore:
                        loadFragment(Constants.KEY_FRAGMENT_COUNTRIES);
                        break;
                    case R.id.action_on_tour:
                        loadFragment(Constants.KEY_FRAGMENT_ONTOUR);
                        break;
                    case R.id.action_more:
                        loadFragment(Constants.KEY_FRAGMENT_MORE);
                        break;
                    default:
                        return true;
                }
                return true;

            }
        });
    }



    private void initFragments() {
        mapFragments.put(Constants.KEY_FRAGMENT_PROFILE, new ProfileFragment(userLogged));
        mapFragments.put(Constants.KEY_FRAGMENT_BOOKINGS, new BookingsFragment());
        //mapFragments.put(Constants.KEY_FRAGMENT_EXPLORE, new ExploreFragment());
        mapFragments.put(Constants.KEY_FRAGMENT_ONTOUR, new OnTourFragment());
        mapFragments.put(Constants.KEY_FRAGMENT_MORE, new MoreFragment());
        mapFragments.put(Constants.KEY_FRAGMENT_COUNTRIES, new CountriesListFragment());

    }

    private void loadFragment(String key) {
        if (mapFragments.containsKey(key)) {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction()
                    .replace(R.id.containerFrameLayout, mapFragments.get(key), key)
                    .commit();
        }
    }

}
