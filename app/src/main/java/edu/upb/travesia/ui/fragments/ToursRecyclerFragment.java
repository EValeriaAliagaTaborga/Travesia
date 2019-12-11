package edu.upb.travesia.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.gson.Gson;

import java.util.List;

import edu.upb.travesia.R;
import edu.upb.travesia.adapters.ToursRecyclerViewAdapter;
import edu.upb.travesia.callback.TourCallback;
import edu.upb.travesia.models.repository.Tour;
import edu.upb.travesia.utils.ToursUtils;

public class ToursRecyclerFragment extends BaseFragment{


    private RecyclerView recyclerView;
    private Gson gson = new Gson();

    public ToursRecyclerFragment() {
        super();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tours_recycler, container, false);
        initViews(view);

        //UserLogged userLogged = this.gson.fromJson(getIntent().getStringExtra(Constants.INTENT_KEY_USER_LOGGED), UserLogged.class);

        ToursUtils toursUtils = new ToursUtils();
        final List<Tour> toursList = toursUtils.getTours();
        ToursRecyclerViewAdapter adapter = new ToursRecyclerViewAdapter(getActivity(), toursList);
        adapter.setTourCallback(new TourCallback() {
            @Override
            public void onTourClick(Tour tour) {
                //Intent intent = new Intent(PokemonRecyclerActivity.this, PokemonDetailsActivity.class);
                //intent.putExtra(Constants.POKEMON_SELECTED, gson.toJson(pokemon));
                //startActivity(intent);
                changeFragment(new ExploreFragment());
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        return view;
    }


    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recyclerViewTours);
    }

}
