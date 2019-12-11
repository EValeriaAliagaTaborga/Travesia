package edu.upb.travesia.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.upb.travesia.R;

public class TourViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textViewName;
    public TextView textViewPrice;

    public TourViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.imageViewTour);
        this.textViewName = itemView.findViewById(R.id.textViewName);
        this.textViewPrice = itemView.findViewById(R.id.textViewPrice);
    }

}
