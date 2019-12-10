package edu.upb.travesia.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

import edu.upb.travesia.R;
import edu.upb.travesia.ui.fragments.BookingsFragment;
import edu.upb.travesia.ui.fragments.ExploreFragment;
import edu.upb.travesia.ui.fragments.MoreFragment;
import edu.upb.travesia.ui.fragments.OnTourFragment;
import edu.upb.travesia.ui.fragments.ProfileFragment;
import edu.upb.travesia.utils.Constants;

public class MainActivity extends AppCompatActivity {



    private BottomNavigationView navigationView;
    private Map<String, Fragment> mapFragments = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

        configureNavigationEvents();
        initFragments();
        loadFragment(Constants.KEY_FRAGMENT_PROFILE);
    }

   private void initUI() {
        navigationView = findViewById(R.id.bottomNavigation);
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
                        loadFragment(Constants.KEY_FRAGMENT_EXPLORE);
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
        mapFragments.put(Constants.KEY_FRAGMENT_PROFILE, new ProfileFragment());
        mapFragments.put(Constants.KEY_FRAGMENT_BOOKINGS, new BookingsFragment());
        mapFragments.put(Constants.KEY_FRAGMENT_EXPLORE, new ExploreFragment());
        mapFragments.put(Constants.KEY_FRAGMENT_ONTOUR, new OnTourFragment());
        mapFragments.put(Constants.KEY_FRAGMENT_MORE, new MoreFragment());
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
