package edu.upb.travesia.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.core.content.ContextCompat;

import com.google.gson.Gson;

import java.util.List;

import edu.upb.travesia.R;
import edu.upb.travesia.adapters.CountriesListViewAdapter;
import edu.upb.travesia.models.repository.Country;
import edu.upb.travesia.utils.Constants;
import edu.upb.travesia.utils.CountriesUtils;

public class CountriesListFragment extends BaseFragment {

    private ListView listview;
    private Gson gson = new Gson();

    public CountriesListFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_countries_list, container, false);
        //initUI(view);
        initViews(view);

        //UserLogged userLogged = this.gson.fromJson(getIntent().getStringExtra(Constants.INTENT_KEY_USER_LOGGED), UserLogged.class);

        CountriesUtils countryUtils = new CountriesUtils();
        final List<Country> countriesList = countryUtils.getCountries();
        CountriesListViewAdapter adapter = new CountriesListViewAdapter(getActivity(), countriesList);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                changeFragment(new CitiesListFragment());
            }
        });
        listview.setAdapter(adapter);
        return view;

    }


    private void initViews(View view) {
        listview = view.findViewById(R.id.listViewCountries);
    }

}
