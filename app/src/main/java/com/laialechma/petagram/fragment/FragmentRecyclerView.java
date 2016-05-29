package com.laialechma.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laialechma.petagram.ActivityContacta;
import com.laialechma.petagram.Presentador.IRecyclerViewFragmentPresenter;
import com.laialechma.petagram.Presentador.RecyclerViewFragmentPresenter;
import com.laialechma.petagram.pojo.Detalle;
import com.laialechma.petagram.MascotaAdaptador;
import com.laialechma.petagram.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecyclerView extends Fragment implements IRecycleviewFragmentView{
    ArrayList<Detalle> mascotas;
    RecyclerView listMascotas;
    IRecyclerViewFragmentPresenter presenter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        // inicializarListMascotas();
        //inicializarAdaptador();
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Detalle> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listMascotas.setAdapter(adaptador);
    }
}

    /*public void inicializarListMascotas(){
        mascotas = new ArrayList<Detalle>();
        mascotas.add (new Detalle(R.drawable.perroup, "Dug", "Tipo: Perro", "Raza: Labrador", "Localización: Cataratas del Paraíso", "Frase favorita: Acabo de conocerte y ya te quiero", 0));
        mascotas.add (new Detalle(R.drawable.rataratatouille, "Remy", "Tipo: Roedor", "Raza: Rata", "Localización: Paris", "Frase favorita: Juntos podemos convertirnos en el mejor chef de París", 0));
        mascotas.add (new Detalle(R.drawable.perrotoystory, "Slinky", "Tipo: Perro", "Raza: Juguete", "Localización: USA", "Frase favorita: Tal vez yo no sea muy listo Buzz, pero se lo que es un suicidio", 0));
        mascotas.add (new Detalle(R.drawable.perrobolt, "Bolt", "Tipo: Perro", "Raza: Pastor blanco Suizo o Shiba inu", "Localización: Hollywood", "Frase favorita: ¡Tengo un superladrido!", 0));
        mascotas.add (new Detalle(R.drawable.gatoshrek, "Gato con Botas", "Tipo: Gato", "Raza: no Raza", "Localización: Muy, muy Lejano", "Frase favorita: ¿Quién oza importunarme?", 0));
        mascotas.add (new Detalle(R.drawable.sven, "Sven", "Tipo: Reno", "Raza: Reno", "Localización: Arendelle", "Frase favorita: ??",0));
    }*/
