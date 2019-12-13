package edu.upb.travesia.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.upb.travesia.R;
import edu.upb.travesia.models.repository.Country;

public class CountriesListViewAdapter extends BaseAdapter {

    private Context context;
    private List<Country> countriesList;

    public CountriesListViewAdapter(Context context, List<Country> countriesList) {
        this.context = context;
        this.countriesList = countriesList;
        Log.e("Adapter - list receive",countriesList.toString());
        Log.e("Adapter - list",this.countriesList.toString());
    }


    @Override
    public int getCount() {
        return this.countriesList.size();
    }

    @Override
    public Country getItem(int position) {
        return this.countriesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        //return this.countriesList.get(position).getId();
        return 0;
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if (vista == null) { //No se puede reciclar
            viewHolder = new ViewHolder();

            //Inflater nos permite usar un layout dentro de un componente
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.countries_list_item, null); //Cual layout y principal o no.

            viewHolder.imageView = vista.findViewById(R.id.imageViewCountry);
            viewHolder.textViewName = vista.findViewById(R.id.textViewName);
            vista.setTag(viewHolder); //Guardar para reciclar
        } else {
            viewHolder = (ViewHolder) vista.getTag(); //Obtener el dato reciclado
        }

        Country country = this.countriesList.get(position);
        int id = context.getResources().getIdentifier("drawable/" + country.getFlag(), "drawable", context.getPackageName());
        viewHolder.imageView.setImageResource(id);
        viewHolder.textViewName.setText(country.getName());
        return vista;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textViewName;
    }
}
