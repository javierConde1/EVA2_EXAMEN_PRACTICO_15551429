package com.example.iowner.eva2_examen_practico;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {
    ArrayList<Restaurantes> rRestaurantes = new ArrayList<Restaurantes>();

    final int RESULTADO_CAPTURAR = 150;
    Intent inCapturar,inMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        inCapturar = new Intent(this,Capturar.class);
        inMostrar = new Intent(this,Mostrar.class);
    }

    public void Capturar(View v){

        startActivityForResult(inCapturar,RESULTADO_CAPTURAR);
    }

    public void Mostrar(View v){
        inMostrar.putExtra("RESTAURANTE",rRestaurantes);
        startActivity(inMostrar);
    }
    public void Salir(View v){
        finish();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULTADO_CAPTURAR){
            if(resultCode == Activity.RESULT_OK){
                Restaurantes rRestaurante = new Restaurantes(data.getStringExtra("NOMBRE"),
                        data.getStringExtra("DESCRIPCION"),data.getStringExtra("DIRECCION"),
                        data.getIntExtra("IMAGEN",0),3);
                rRestaurantes.add(rRestaurante);
            }
        }
    }
}
