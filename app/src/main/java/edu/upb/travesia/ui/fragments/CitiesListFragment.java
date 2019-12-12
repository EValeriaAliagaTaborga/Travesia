package edu.upb.travesia.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

import edu.upb.travesia.R;
import edu.upb.travesia.adapters.CitiesListViewAdapter;
import edu.upb.travesia.models.repository.City;
import edu.upb.travesia.models.repository.Tour;
import edu.upb.travesia.utils.CitiesUtils;

public class CitiesListFragment extends BaseFragment {

    private ListView listview;
    private Gson gson = new Gson();
    private List<City> citiesList;

    public CitiesListFragment(List<City> citiesList) {
        this.citiesList = citiesList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cities_list, container, false);
        //initViews(view);
        listview = view.findViewById(R.id.listViewCities);

        //UserLogged userLogged = this.gson.fromJson(getIntent().getStringExtra(Constants.INTENT_KEY_USER_LOGGED), UserLogged.class);

        //CitiesUtils cityUtils = new CitiesUtils();
        //final List<City> citiesList = cityUtils.getCities();
        CitiesListViewAdapter adapter = new CitiesListViewAdapter(getActivity(), citiesList);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                List<Tour> toursList = citiesList.get(position).getTours();
                changeFragment(new ToursRecyclerFragment(toursList));
            }
        });
        listview.setAdapter(adapter);
        return view;

    }


    private void initViews(View view) {
        listview = view.findViewById(R.id.listViewCities);
    }

}
