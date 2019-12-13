package edu.upb.travesia.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.upb.travesia.R;
import edu.upb.travesia.callback.TourCallback;
import edu.upb.travesia.models.repository.Tour;

public class ToursRecyclerViewAdapter extends RecyclerView.Adapter<TourViewHolder>{

    private List<Tour> toursList;
    private LayoutInflater inflater;
    private TourCallback tourCallback;

    public ToursRecyclerViewAdapter(Context context, List<Tour> toursList) {
        this.toursList = toursList;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = this.inflater.inflate(R.layout.tours_list_item, null);
        return new TourViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder tourViewHolder, int position) {
        final Tour tour = this.toursList.get(position);
        //tourViewHolder.imageView.setImageResource(tour.getPicture());
        tourViewHolder.imageView.setImageURI(Uri.parse("android.resource://edu.upb.travesia/drawable/"+tour.getPicture()));

        tourViewHolder.textViewName.setText(tour.getName());
        tourViewHolder.textViewPrice.setText(tour.getPrice()+"");
        tourViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tourCallback != null) {
                    tourCallback.onTourClick(tour);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.toursList.size();
    }

    public void setTourCallback(TourCallback tourCallback) {
        this.tourCallback = tourCallback;
    }}
