package com.laialechma.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laialechma.petagram.ActivityContacta;
import com.laialechma.petagram.Detalle;
import com.laialechma.petagram.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPerfil extends Fragment {

    ArrayList<Detalle> mascotas;
    RecyclerView listMascotas;
    Toolbar toolbar;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public FragmentPerfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_recyclerview, container, false);


        listMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);


        /* LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);*/

        listMascotas.setLayoutManager(glm);
        inicializarListMascotas();
        inicializarAdaptador();

        return v;
    }
    public ActivityContacta.MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        ActivityContacta.MascotaAdaptador adaptador = new ActivityContacta.MascotaAdaptador(mascotas);
        listMascotas.setAdapter(adaptador);
    }

    public void inicializarListMascotas(){
        mascotas = new ArrayList<Detalle>();
        mascotas.add (new Detalle(R.drawable.gatoshrek1,"","","","","", 0));
        mascotas.add (new Detalle(R.drawable.gatoshrek2,"","","","","", 0));
        mascotas.add (new Detalle(R.drawable.gatoshrek3,"","","","","", 0));
    }

}
