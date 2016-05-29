package com.laialechma.petagram.Presentador;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.laialechma.petagram.MascotaAdaptador;
import com.laialechma.petagram.db.ConstructorMascotas;
import com.laialechma.petagram.fragment.IRecycleviewFragmentView;
import com.laialechma.petagram.pojo.Detalle;

import java.util.ArrayList;

/**
 * Created by Laia Lechma on 28/05/2016.
 */
public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    IRecycleviewFragmentView iRecycleviewFragmentView;
    Context context;
    ConstructorMascotas constructorMascotas;
    ArrayList<Detalle> mascotas;

    public RecyclerViewFragmentPresenter (IRecycleviewFragmentView iRecycleviewFragmentView, Context context) {
        this.iRecycleviewFragmentView = iRecycleviewFragmentView;
        this.context =context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
            constructorMascotas = new ConstructorMascotas(context);
            mascotas = constructorMascotas.obtenerDatos ();
            mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
            iRecycleviewFragmentView.inicializarAdaptadorRV(iRecycleviewFragmentView.crearAdaptador(mascotas));
            iRecycleviewFragmentView.generarLinearLayoutVertical();
    }
}
