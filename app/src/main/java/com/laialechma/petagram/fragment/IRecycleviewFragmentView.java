package com.laialechma.petagram.fragment;

import com.laialechma.petagram.pojo.Detalle;
import com.laialechma.petagram.MascotaAdaptador;

import java.util.ArrayList;

/**
 * Created by Laia Lechma on 26/05/2016.
 */
public interface IRecycleviewFragmentView {

    public void generarLinearLayoutVertical ();

    public MascotaAdaptador crearAdaptador (ArrayList<Detalle> mascotas);

    public void inicializarAdaptadorRV (MascotaAdaptador adaptador);


}
