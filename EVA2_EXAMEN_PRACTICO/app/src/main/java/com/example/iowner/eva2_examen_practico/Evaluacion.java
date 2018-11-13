package com.example.iowner.eva2_examen_practico;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Evaluacion extends AppCompatActivity implements RatingBar.OnRatingBarChangeListener{

    ImageView mainImage;
    TextView nombre, descripcion, direccion;
    RatingBar rating;
    Intent inResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluacion_restaurante);
        inResult = getIntent();
        mainImage = findViewById(R.id.mainImageResIV);
        nombre = findViewById(R.id.nombreResTV);
        descripcion = findViewById(R.id.descResTV);
        direccion = findViewById(R.id.direccionResTV);
        rating = findViewById(R.id.opinionResRB);
        rating.setOnRatingBarChangeListener(this);
        Restaurantes restaurante = (Restaurantes) inResult.getSerializableExtra("RESTAURANTE");
        mainImage.setImageResource(restaurante.getiImagen());
        nombre.setText(restaurante.getsNombre());
        descripcion.setText(restaurante.getsDescripcion());
        direccion.setText(restaurante.getsDireccionTelefono());
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
        int rating = (int) ratingBar.getRating();
        Toast.makeText(this, "Has evaluado con " + rating + " estrellas.",Toast.LENGTH_SHORT).show();
        inResult.putExtra("rating", rating);
        setResult(Activity.RESULT_OK,inResult);
        finish();
    }
}
