package com.laialechma.petagram;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Laia Lechma on 20/05/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        ImageView imgfotoCV;
        TextView tvNombreCV;
        TextView tvTipoCV;
        TextView tvRazaCV;
        TextView tvLocalizacionCV;
        TextView tvFraseCV;
        TextView ranting;
        ImageView iconoHuesoBlanco;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgfotoCV = (ImageView) itemView.findViewById(R.id.imgfotoCV);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTipoCV = (TextView) itemView.findViewById(R.id.tvTipoCV);
            tvRazaCV = (TextView) itemView.findViewById(R.id.tvRazaCV);
            tvLocalizacionCV = (TextView) itemView.findViewById(R.id.tvLocalizacionCV);
            tvFraseCV = (TextView) itemView.findViewById(R.id.tvFraseCV);
            ranting = (TextView) itemView.findViewById(R.id.ranting);
            iconoHuesoBlanco = (ImageView) itemView.findViewById(R.id.iconoHuesoBlanco);
        }


    }


    ArrayList<Detalle> mascotas;

    MascotaAdaptador (ArrayList<Detalle> mascotas){
        this.mascotas = mascotas;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int i) {
        final Detalle mascota = mascotas.get(i);
        mascotaViewHolder.imgfotoCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvTipoCV.setText(mascota.getTipo());
        mascotaViewHolder.tvRazaCV.setText(mascota.getRaza());
        mascotaViewHolder.tvLocalizacionCV.setText(mascota.getLocalizacion());
        mascotaViewHolder.tvFraseCV.setText(mascota.getFrase());

        mascotaViewHolder.iconoHuesoBlanco.setTag(mascotaViewHolder);

        if (mascota.getRanting() == 0)
            mascotaViewHolder.iconoHuesoBlanco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MascotaViewHolder mascotaViewHolderHueso = (MascotaViewHolder) v.getTag();
                    mascotaViewHolderHueso.ranting.setText(String.valueOf(1 + Integer.parseInt(mascotaViewHolderHueso.ranting.getText().toString())));

                }
            });


    }

    @Override
    public int getItemCount() {

        return mascotas.size();
    }


}
