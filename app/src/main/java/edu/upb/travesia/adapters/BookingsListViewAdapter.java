package edu.upb.travesia.adapters;

import android.content.Context;
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
import edu.upb.travesia.models.repository.firebase.Book;
import edu.upb.travesia.models.repository.firebase.Booking;

public class BookingsListViewAdapter extends BaseAdapter {

    private Context context;
    private List<Booking> bookingsList;

    public BookingsListViewAdapter(Context context, List<Booking> bookingsList) {
        this.context = context;
        this.bookingsList = bookingsList;

        //Log.e("Adapter - list receive",countriesList.toString());
        //Log.e("Adapter - list",this.countriesList.toString());
    }


    @Override
    public int getCount() {
        return this.bookingsList.size();
    }

    @Override
    public Booking getItem(int position) {
        return this.bookingsList.get(position);
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
            vista = inflater.inflate(R.layout.bookings_list_item, null); //Cual layout y principal o no.

            viewHolder.imageView = vista.findViewById(R.id.imageViewBookings);
            viewHolder.textViewName = vista.findViewById(R.id.txtTitleBook);
            viewHolder.textViewPrice = vista.findViewById(R.id.txtPriceBook);
            vista.setTag(viewHolder); //Guardar para reciclar
        } else {
            viewHolder = (ViewHolder) vista.getTag(); //Obtener el dato reciclado
        }

        Booking booking = this.bookingsList.get(position);
        Book book = booking.getBookings().get(0);
        int id = context.getResources().getIdentifier("drawable/" + book.getTourImg(), "drawable", context.getPackageName());
        viewHolder.imageView.setImageResource(id);
        viewHolder.textViewName.setText(book.getTourTitle());
        //viewHolder.textViewPrice.setText(book.getTourPrice()+"");
        viewHolder.textViewPrice.setText(book.getDate());
        return vista;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewPrice;
    }
}
