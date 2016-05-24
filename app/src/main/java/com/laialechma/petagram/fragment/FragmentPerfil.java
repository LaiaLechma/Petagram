package com.laialechma.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.laialechma.petagram.ActivityContacta;
import com.laialechma.petagram.Detalle;
import com.laialechma.petagram.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPerfil extends Fragment {

    ArrayList<Detalle> mascotas;
    RecyclerView listMascotas;
    CircularImageView circularImageView;
    TextView tvNombre;

    public FragmentPerfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_perfil, container, false);



        /* LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);*/


        listMascotas = (RecyclerView) v.findViewById(R.id.rvMascotasperfil);
        listMascotas.setClickable(false);
        listMascotas.setEnabled(false);
        listMascotas.setLayoutFrozen(true);
        listMascotas.setItemAnimator(new DefaultItemAnimator());

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);

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
        mascotas.add (new Detalle(R.drawable.gatoshrek1,"","","","","", 20));
        mascotas.add (new Detalle(R.drawable.gatoshrek2,"","","","","", 3));
        mascotas.add (new Detalle(R.drawable.gatoshrek3,"","","","","", 5));
    }

}
