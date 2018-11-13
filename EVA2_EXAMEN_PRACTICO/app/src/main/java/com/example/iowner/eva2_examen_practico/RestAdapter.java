package com.example.iowner.eva2_examen_practico;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RestAdapter extends ArrayAdapter<Restaurantes> {
    private Context context;
    private int resource;
    private ArrayList<Restaurantes> restaurantes;

    public RestAdapter(@NonNull Context context, int resource, ArrayList<Restaurantes> restaurantes) {
        super(context, resource, restaurantes);
        this.context = context;
        this.resource = resource;
        this.restaurantes = restaurantes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView mainImage, star1, star2, star3;
        TextView nombre, descripcion, direccion;
        View currentView = convertView;
        if (currentView == null) {
            LayoutInflater liVista = ((Activity) context).getLayoutInflater();
            currentView = liVista.inflate(resource, parent, false);
        }
        mainImage = currentView.findViewById(R.id.mainIV);
        star1 = currentView.findViewById(R.id.star1IV);
        star2 = currentView.findViewById(R.id.star2IV);
        star3 = currentView.findViewById(R.id.star3IV);
        nombre = currentView.findViewById(R.id.nombreTV);
        descripcion = currentView.findViewById(R.id.descripcionTV);
        direccion = currentView.findViewById(R.id.direccionTV);

        Restaurantes currentRes = restaurantes.get(position);

        mainImage.setImageResource(currentRes.getiImagen());
        nombre.setText(currentRes.getsNombre());
        descripcion.setText(currentRes.getsDescripcion());
        direccion.setText(currentRes.getsDireccionTelefono());
        int review = currentRes.getiOpinion();
        switch (review) {
            case 1:
                star1.setImageResource(R.drawable.star_full);
                star2.setImageResource(R.drawable.star_empty);
                star3.setImageResource(R.drawable.star_empty);
                break;
            case 2:
                star1.setImageResource(R.drawable.star_full);
                star2.setImageResource(R.drawable.star_full);
                star3.setImageResource(R.drawable.star_empty);
                break;
            case 3:
                star1.setImageResource(R.drawable.star_full);
                star2.setImageResource(R.drawable.star_full);
                star3.setImageResource(R.drawable.star_full);
                break;
            default:
                star1.setImageResource(R.drawable.star_empty);
                star2.setImageResource(R.drawable.star_empty);
                star3.setImageResource(R.drawable.star_empty);
                break;
        }
        return currentView;

    }
}
