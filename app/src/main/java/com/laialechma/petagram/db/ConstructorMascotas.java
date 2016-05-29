package com.laialechma.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.laialechma.petagram.pojo.Detalle;
import com.laialechma.petagram.R;

import java.util.ArrayList;

/**
 * Created by Laia Lechma on 28/05/2016.
 */
public class ConstructorMascotas {

    private Context context;
    private static final int RANTING = 1;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Detalle> obtenerDatos (){
       /* ArrayList <Detalle> mascotas = new ArrayList<Detalle>();
        mascotas.add (new Detalle(R.drawable.perroup, "Dug", "Tipo: Perro", "Raza: Labrador", "Localización: Cataratas del Paraíso", "Frase favorita: Acabo de conocerte y ya te quiero", 0));
        mascotas.add (new Detalle(R.drawable.rataratatouille, "Remy", "Tipo: Roedor", "Raza: Rata", "Localización: Paris", "Frase favorita: Juntos podemos convertirnos en el mejor chef de París", 0));
        mascotas.add (new Detalle(R.drawable.perrotoystory, "Slinky", "Tipo: Perro", "Raza: Juguete", "Localización: USA", "Frase favorita: Tal vez yo no sea muy listo Buzz, pero se lo que es un suicidio", 0));
        mascotas.add (new Detalle(R.drawable.perrobolt, "Bolt", "Tipo: Perro", "Raza: Pastor blanco Suizo o Shiba inu", "Localización: Hollywood", "Frase favorita: ¡Tengo un superladrido!", 0));
        mascotas.add (new Detalle(R.drawable.gatoshrek, "Gato con Botas", "Tipo: Gato", "Raza: no Raza", "Localización: Muy, muy Lejano", "Frase favorita: ¿Quién oza importunarme?", 0));
        mascotas.add (new Detalle(R.drawable.sven, "Sven", "Tipo: Reno", "Raza: Reno", "Localización: Arendelle", "Frase favorita: ??",0));
        return mascotas;*/

        BaseDatos db =new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public void insertarMascotas (BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Dug");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_TIPO, "Remy");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_RAZA, "Slinky");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_LOCALIZACIÓN, "Bolt");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FRASE, "Gato con Botas");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.sven);

        db.insertarMascota(contentValues);
    }


    public void insertarRantingMascota (Detalle mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_RANTING, RANTING);
        db.insertarRantingMascota(contentValues);
    }

    public int obtenerRantingMascota(Detalle mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRantingMascota(mascota);
    }

}
