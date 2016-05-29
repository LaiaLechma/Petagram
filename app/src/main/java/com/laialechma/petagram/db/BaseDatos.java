package com.laialechma.petagram.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.laialechma.petagram.pojo.Detalle;

import java.util.ArrayList;

/**
 * Created by Laia Lechma on 27/05/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_TIPO + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_RAZA + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_LOCALIZACIÓN + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FRASE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER" +
                ")";
        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_RANTING + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST" + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST" + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS);
        onCreate(db);
    }

    public ArrayList <Detalle> obtenerTodasLasMascotas (){
        ArrayList <Detalle> mascota = new ArrayList<>();


        String query = "SELECT * FROM" + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Detalle mascotaActual = new Detalle();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setTipo(registros.getString(2));
            mascotaActual.setRaza(registros.getString(3));
            mascotaActual.setLocalizacion(registros.getString(4));
            mascotaActual.setFrase(registros.getString(5));
            mascotaActual.setFoto(registros.getInt(6));

            String queryRanting = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_RANTING+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosRanting = db.rawQuery(queryRanting, null);
            if (registrosRanting.moveToNext()){
                mascotaActual.setRanting(registrosRanting.getInt(0));
            }else {
                mascotaActual.setRanting(0);
            }

            mascota.add(mascotaActual);
        }

        db.close();

        return mascota;
    }

    public void insertarMascota (ContentValues contentValues) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
            db.close();
    }

    public void insertarRantingMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTAS, null, contentValues);
        db.close();
    }


    public int obtenerRantingMascota (Detalle mascota){
        int ranting = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_RANTING+")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTAS_ID_MASCOTA + "="+mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            ranting = registros.getInt(0);
        }

        db.close();

        return ranting;
    }
}
