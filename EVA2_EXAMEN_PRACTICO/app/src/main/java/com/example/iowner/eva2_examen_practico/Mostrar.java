package com.example.iowner.eva2_examen_practico;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Mostrar extends AppCompatActivity implements ListView.OnItemClickListener {

    ArrayList<Restaurantes> rRest;
    ListView lvRest;
    Intent inPrincipal;
    Intent inMostrar;
    int MOSTRAR = 110;
    Restaurantes restSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        inPrincipal = getIntent();

        //se utilizo una lista para llenar los campos de la clase capturar
        rRest = (ArrayList<Restaurantes>) inPrincipal.getSerializableExtra("RESTAURANTE");
        //Log.d("lmao", Arrays.toString(rRest.toArray()));
        lvRest = findViewById(R.id.listViewRestaurantes);
        lvRest.setAdapter(new RestAdapter(this, R.layout.layout_restaurante, rRest));
        lvRest.setOnItemClickListener(this);
        inMostrar = new Intent(this, Evaluacion.class);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        restSeleccionado = rRest.get(i);
        inMostrar.putExtra("RESTAURANTE", rRest.get(i));
        startActivityForResult(inMostrar, MOSTRAR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MOSTRAR) {
            if (resultCode == Activity.RESULT_OK) {
                restSeleccionado.setiOpinion(data.getIntExtra("rating", 0));
                lvRest.invalidateViews();
            }
        }
    }
}
