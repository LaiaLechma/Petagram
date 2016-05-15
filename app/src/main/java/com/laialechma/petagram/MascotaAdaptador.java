package com.laialechma.petagram;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Laia Lechma on 15/05/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Detalle> mascotas;

    public MascotaAdaptador (ArrayList<Detalle> mascotas){
        this.mascotas = mascotas;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder MascotaViewHolder, int position) {
        Detalle mascota = mascotas.get(position);
        MascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        MascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        MascotaViewHolder.tvTipoCV.setText(mascota.getTipo());
        MascotaViewHolder.tvRazaCV.setText(mascota.getRaza());
        MascotaViewHolder.tvLocalizacionCV.setText(mascota.getLocalizacion());
        MascotaViewHolder.tvFraseCV.setText(mascota.getFrase());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTipoCV;
        private TextView tvRazaCV;
        private TextView tvLocalizacionCV;
        private TextView tvFraseCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgfoto);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTipoCV = (TextView) itemView.findViewById(R.id.tvTipoCV);
            tvRazaCV = (TextView) itemView.findViewById(R.id.tvRazaCV);
            tvLocalizacionCV = (TextView) itemView.findViewById(R.id.tvLocalizacionCV);
            tvFraseCV = (TextView) itemView.findViewById(R.id.tvFraseCV);
        }
    }
}
