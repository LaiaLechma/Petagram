package com.laialechma.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Detalle> mascotas;
    private RecyclerView listMascotas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
            setSupportActionBar(miActionBar);


            listMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

            LinearLayoutManager llm = new LinearLayoutManager(this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);

            listMascotas.setLayoutManager(llm);
            inicializarListMascotas();
            inicializarAdaptador();
    }


    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listMascotas.setAdapter(adaptador);
    }


    public void inicializarListMascotas(){
        mascotas = new ArrayList<Detalle>();
        mascotas.add (new Detalle(R.drawable.perroup, "Dug", "Perro", "Labrador", "Cataratas del Paraíso", "Acabo de conocerte y ya te quiero"));
        mascotas.add (new Detalle(R.drawable.rataratatouille, "Remy", "Roedor", "Rata", "Paris", "Juntos podemos convertirnos en el mejor chef de París"));
        mascotas.add (new Detalle(R.drawable.perrotoystory, "Slinky", "Perro", "Juguete", "USA", "Tal vez yo no sea muy listo Buzz, pero se lo que es un suicidio"));
        mascotas.add (new Detalle(R.drawable.perrobolt, "Bolt", "Perro", "Pastor blanco Suizo o Shiba inu", "Hollywood", "¡Tengo un superladrido!"));
        mascotas.add (new Detalle(R.drawable.gatoshrek, "Gato con Botas", "Gato", "Labrador", "Muy, muy Lejano", "¿Quién oza importunarme?"));
    }
}


            /*
            ArrayList<String> nombresDetalleMascotas = new ArrayList<>();
            for (Detalle detallesMascotas : mascotas) {
                nombresDetalleMascotas.add(detallesMascotas.getNombre());
            }


            ListView listMascotas = (ListView) findViewById(R.id.listMascotas);
            listMascotas.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,nombresDetalleMascotas));


            listMascotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(MainActivity.this, DetalleMascota.class);
                    intent.putExtra("Nombre", mascotas.get(position).getNombre());
                    intent.putExtra("Tipo", mascotas.get(position).getTipo());
                    intent.putExtra("Raza", mascotas.get(position).getRaza());
                    intent.putExtra("Localizacion", mascotas.get(position).getLocalizacion());
                    intent.putExtra("Frase", mascotas.get(position).getFrase());
                    startActivity(intent);
                }
            });*/