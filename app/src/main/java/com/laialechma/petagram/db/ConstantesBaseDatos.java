package com.laialechma.petagram.db;

/**
 * Created by Laia Lechma on 27/05/2016.
 */
public final class ConstantesBaseDatos {

    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTAS               = "mascota";
    public static final String TABLE_MASCOTAS_ID            = "id";
    public static final String TABLE_MASCOTAS_NOMBRE        = "nombre";
    public static final String TABLE_MASCOTAS_TIPO          = "tipo";
    public static final String TABLE_MASCOTAS_RAZA          = "raza";
    public static final String TABLE_MASCOTAS_LOCALIZACIÓN  = "localizacion";
    public static final String TABLE_MASCOTAS_FRASE         = "frase";
    public static final String TABLE_MASCOTAS_FOTO          = "foto";

    public static final String TABLE_LIKES_MASCOTAS = "mascota_likes";
    public static final String TABLE_LIKES_MASCOTAS_ID = "id";
    public static final String TABLE_LIKES_MASCOTAS_ID_MASCOTA = "id_mascota";
    public static final String TABLE_LIKES_MASCOTAS_RANTING     = "ranting";
}
