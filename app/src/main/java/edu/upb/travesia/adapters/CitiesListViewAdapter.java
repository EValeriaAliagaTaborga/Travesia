package edu.upb.travesia.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.upb.travesia.R;
import edu.upb.travesia.models.repository.City;

public class CitiesListViewAdapter extends BaseAdapter {

    private Context context;
    private List<City> citiesList;

    public CitiesListViewAdapter(Context context, List<City> citiesList) {
        this.context = context;
        this.citiesList = citiesList;
    }


    @Override
    public int getCount() {
        return this.citiesList.size();
    }

    @Override
    public City getItem(int position) {
        return this.citiesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        //return this.citiesList.get(position).getId();
        return 0;
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if (vista == null) { //No se puede reciclar
            viewHolder = new ViewHolder();

            //Inflater nos permite usar un layout dentro de un componente
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.cities_list_item, null); //Cual layout y principal o no.

            viewHolder.imageView = vista.findViewById(R.id.imageViewCity);
            viewHolder.textViewName = vista.findViewById(R.id.textViewName);
            vista.setTag(viewHolder); //Guardar para reciclar
        } else {
            viewHolder = (ViewHolder) vista.getTag(); //Obtener el dato reciclado
        }

        City city = this.citiesList.get(position);
        viewHolder.imageView.setImageResource(R.drawable.ic_place_blue_24dp);
        viewHolder.textViewName.setText(city.getName());
        return vista;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textViewName;
    }
}
