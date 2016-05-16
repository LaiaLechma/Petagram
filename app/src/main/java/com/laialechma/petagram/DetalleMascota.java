package com.laialechma.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DetalleMascota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("Nombre");
        String tipo = parametros.getString("Tipo");
        String raza = parametros.getString("Raza");
        String localizacion = parametros.getString("Localizacion");
        String frase = parametros.getString("Frase");

        TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        TextView tvTipo = (TextView) findViewById(R.id.tvTipo);
        TextView tvRaza = (TextView) findViewById(R.id.tvRaza);
        TextView tvLocalizacion = (TextView) findViewById(R.id.tvLocalizacion);
        TextView tvFrase = (TextView) findViewById(R.id.tvFrase);

        tvNombre.setText(nombre);
        tvTipo.setText(tipo);
        tvRaza.setText(raza);
        tvLocalizacion.setText(localizacion);
        tvFrase.setText(frase);


    }
}
