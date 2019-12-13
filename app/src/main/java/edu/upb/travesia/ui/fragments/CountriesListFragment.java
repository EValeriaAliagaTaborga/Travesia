package edu.upb.travesia.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import edu.upb.travesia.R;
import edu.upb.travesia.adapters.CountriesListViewAdapter;
import edu.upb.travesia.models.repository.Base;
import edu.upb.travesia.models.repository.City;
import edu.upb.travesia.models.repository.Country;
import edu.upb.travesia.utils.Constants;
import edu.upb.travesia.utils.CountriesUtils;

public class CountriesListFragment extends BaseFragment {

    private ListView listview;
    private Gson gson = new Gson();
    List<Country> countriesList;

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

        //CountriesUtils countryUtils = new CountriesUtils();
        //List<Country> countriesList = countryUtils.getCountries();

        countriesListAndAdapter();
        return view;

    }


    private void initViews(View view) {
        listview = view.findViewById(R.id.listViewCountries);
        //Log.e("listview:",listview.toString());
    }


    private void countriesListAndAdapter() {

        viewModel.getCountries().observe(this, new Observer<Base>() {
            @Override
            public void onChanged(Base base) {
                if (base.isSuccess()) {
                    List<Country> countries = (List<Country>) base.getData();
                    //Log.e("Cantidad de paises", "" + countries.size());

                    for (Country country : countries) {
                        Log.e("Pais:", "" + country.getCities().get(0).getName());
                    }
                    countriesList = countries;
                    CountriesListViewAdapter adapter = new CountriesListViewAdapter(getActivity(), countriesList);
                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //changeFragment(new CitiesListFragment());
                            List<City> cityList = countriesList.get(position).getCities();
                            changeFragment(new CitiesListFragment(cityList));
                        }
                    });
                    listview.setAdapter(adapter);

                } else {
                    Log.e("Error:", base.getMessage());
                    if (base.getException() != null) {
                        Log.e("Exception:", "" + base.getException().getMessage());
                    }
                    //countriesList = new ArrayList<>();
                }
            }
        });
    }

}
