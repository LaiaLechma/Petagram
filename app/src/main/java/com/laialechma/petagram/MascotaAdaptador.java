package com.laialechma.petagram;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.laialechma.petagram.db.ConstructorMascotas;
import com.laialechma.petagram.pojo.Detalle;

import java.util.ArrayList;

/**
 * Created by Laia Lechma on 20/05/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Detalle> mascotas;
    Activity activity;

    public MascotaAdaptador (ArrayList<Detalle> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
      }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int i) {
        final Detalle mascota = mascotas.get(i);
        mascotaViewHolder.imgfotoCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvTipoCV.setText(mascota.getTipo());
        mascotaViewHolder.tvRazaCV.setText(mascota.getRaza());
        mascotaViewHolder.tvLocalizacionCV.setText(mascota.getLocalizacion());
        mascotaViewHolder.tvFraseCV.setText(mascota.getFrase());
        mascotaViewHolder.ranting.setText(String.valueOf(mascota.getRanting()) + " " + activity.getString(R.string.plikes));


        mascotaViewHolder.imgfotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleMascota.class);
                intent.putExtra("Nombre", mascota.getNombre());
                intent.putExtra("Tipo", mascota.getTipo());
                intent.putExtra("Raza", mascota.getRaza());
                intent.putExtra("Localizacion", mascota.getLocalizacion());
                intent.putExtra("Frase", mascota.getFrase());
                activity.startActivity(intent);

            }
        });

        /*
         mascotaViewHolder.iconoHuesoBlanco.setTag(mascotaViewHolder);
            mascotaViewHolder.iconoHuesoBlanco.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MascotaViewHolder mascotaViewHolderHueso = (MascotaViewHolder) v.getTag();
                    mascotaViewHolderHueso.ranting.setText(String.valueOf(1 + Integer.parseInt(mascotaViewHolderHueso.ranting.getText().toString())));

                }
            });*/

            mascotaViewHolder.iconoHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();


                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.insertarRantingMascota(mascota);
                mascotaViewHolder.ranting.setText(constructorMascotas.obtenerRantingMascota(mascota) + " " + activity.getString(R.string.plikes));


            }
        });
    }

    @Override
    public int getItemCount() {

        return mascotas.size();
    }

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
}
