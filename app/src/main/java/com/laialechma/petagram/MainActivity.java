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
        mascotas.add (new Detalle(R.drawable.perroup, "Dug", "Tipo: Perro", "Raza: Labrador", "Localización: Cataratas del Paraíso", "Frase favorita: Acabo de conocerte y ya te quiero", 0));
        mascotas.add (new Detalle(R.drawable.rataratatouille, "Remy", "Tipo: Roedor", "Raza: Rata", "Localización: Paris", "Frase favorita: Juntos podemos convertirnos en el mejor chef de París", 0));
        mascotas.add (new Detalle(R.drawable.perrotoystory, "Slinky", "Tipo: Perro", "Raza: Juguete", "Localización: USA", "Frase favorita: Tal vez yo no sea muy listo Buzz, pero se lo que es un suicidio", 0));
        mascotas.add (new Detalle(R.drawable.perrobolt, "Bolt", "Tipo: Perro", "Raza: Pastor blanco Suizo o Shiba inu", "Localización: Hollywood", "Frase favorita: ¡Tengo un superladrido!", 0));
        mascotas.add (new Detalle(R.drawable.gatoshrek, "Gato con Botas", "Tipo: Gato", "Raza: Labrador", "Localización: Muy, muy Lejano", "Frase favorita: ¿Quién oza importunarme?", 0));
        mascotas.add (new Detalle(R.drawable.gatoshrek, "Sven", "Tipo: Reno", "Raza: Reno", "Localización: Arendelle", "Frase favorita: ??",0));
    }
    public void iraFavoritos(View v){
        Intent intent= new Intent(this,ActivityFavoritos.class);
        startActivity(intent);
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