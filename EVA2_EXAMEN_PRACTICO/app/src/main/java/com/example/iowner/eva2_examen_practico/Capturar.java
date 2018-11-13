package com.example.iowner.eva2_examen_practico;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Capturar extends AppCompatActivity {
    String sNombre, sDescripcion, sDireccionTelefono;
    int iImagen;

    Intent inImagen, inPrincipal;
    final int RESPUESTA_IMAGEN = 100;

    EditText editTxtNombre, editTxtDescripcion, editTxtDirTel;
    ImageView imgViewRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capturar);
        inPrincipal = getIntent();

        editTxtNombre = findViewById(R.id.editTxtNombre);
        editTxtDescripcion = findViewById(R.id.editTxtDescripcion);
        editTxtDirTel = findViewById(R.id.editTxtDirTel);
        imgViewRes = findViewById(R.id.imgViewRes);

        inImagen = new Intent(this, SelecImagenes.class);

    }

    public void Imagen(View v) {
        startActivityForResult(inImagen, RESPUESTA_IMAGEN);
    }

    public void Guardar(View v) {
        //se inserta en las variables el contenido de los widgets
        sNombre = editTxtNombre.getText().toString();
        sDescripcion = editTxtDescripcion.getText().toString();
        sDireccionTelefono = editTxtDirTel.getText().toString();
        //aqui se ponen los datos en los extra
        inPrincipal.putExtra("NOMBRE", sNombre);
        inPrincipal.putExtra("DESCRIPCION", sDescripcion);
        inPrincipal.putExtra("DATOS", sDireccionTelefono);
        inPrincipal.putExtra("IMAGEN", iImagen);

        setResult(Activity.RESULT_OK, inPrincipal);

        Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show();

        finish();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESPUESTA_IMAGEN) {
            if (resultCode == Activity.RESULT_OK) {
                iImagen = data.getIntExtra("IMAGEN", 0);
                imgViewRes.setImageResource(iImagen);
            }
        }
    }
}
