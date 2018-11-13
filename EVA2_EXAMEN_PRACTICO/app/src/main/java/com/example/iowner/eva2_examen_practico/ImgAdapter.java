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

public class ImgAdapter extends ArrayAdapter<Integer> {
    Context cContexto;
    int iLayoaut;
    Integer[] iImages;

    public ImgAdapter(@NonNull Context context, int resource, @NonNull Integer[] objects) {
        super(context, resource, objects);
        cContexto = context;
        iLayoaut = resource;
        iImages = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imgVw;
        View vFila = convertView;
        if(vFila == null){
            LayoutInflater liVista = ((Activity)cContexto).getLayoutInflater();
            vFila = liVista.inflate(iLayoaut,parent,false);

        }
        imgVw = vFila.findViewById(R.id.imgViewImg6);

        Integer cActual = iImages[position];
        imgVw.setImageResource(cActual.intValue());
        return vFila;

    }
}
