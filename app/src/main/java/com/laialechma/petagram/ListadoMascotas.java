package com.laialechma.petagram;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListadoMascotas extends AppCompatActivity {

    SwipeRefreshLayout SWLayout;
    ListView ListMascotas;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_mascotas);

        SWLayout = (SwipeRefreshLayout) findViewById(R.id.SWLayout);
        ListMascotas = (ListView) findViewById(R.id.ListMascotas);

        String[] nombre = getResources().getStringArray(R.array.Nombre);
        ListMascotas.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, nombre));

        SWLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });

    }

    public void refrescandoContenido(){
        String[] nombre = getResources().getStringArray(R.array.Nombre);
        ListMascotas.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, nombre));
        SWLayout.setRefreshing(false);
}
}
