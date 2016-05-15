package com.laialechma.petagram;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListadoMascotas extends AppCompatActivity {

    ArrayList<DetallesMascotas> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mascotas = new ArrayList<DetallesMascotas>();
        mascotas.add (new DetallesMascotas("Dug", "Perro", "Labrador", "Cataratas del Paraíso", "Acabo de conocerte y ya te quiero"));
        mascotas.add (new DetallesMascotas("Remy", "Roedor", "Rata", "Paris", "Juntos podemos convertirnos en el mejor chef de París"));
        mascotas.add (new DetallesMascotas("Slinky", "Perro", "Juguete", "USA", "Tal vez yo no sea muy listo Buzz, pero se lo que es un suicidio"));
        mascotas.add (new DetallesMascotas("Bolt", "Perro", "Pastor blanco Suizo o Shiba inu", "Hollywood", "¡Tengo un superladrido!"));
        mascotas.add (new DetallesMascotas("Gato con Botas", "Gato", "Labrador", "Muy, muy Lejano", "¿Quién oza importunarme?"));

        ArrayList<String> nombresDetalleMascotas = new ArrayList<>();
        for (DetallesMascotas detallesMascotas : mascotas) {
            nombresDetalleMascotas.add(detallesMascotas.getNombre());
            
        }
        
        ListView ListMascotas = (ListView) findViewById(R.id.ListMascotas);
        ListMascotas.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresDetalleMascotas));

        ListMascotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }


}
