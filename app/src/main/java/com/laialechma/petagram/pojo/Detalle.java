package com.laialechma.petagram.pojo;

/**
 * Created by Laia Lechma on 15/05/2016.
 */
public class Detalle {

    private String nombre;
    private int id;
    private String tipo;
    private String raza;
    private String localizacion;
    private String frase;
    private int foto;
    private int ranting;

    public Detalle(int foto, String nombre, String tipo, String raza, String localizacion, String frase, int ranting) {
        this.foto = foto;
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
        this.localizacion = localizacion;
        this.frase = frase;
        this.ranting = ranting;
    }

    public Detalle() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public int getRanting() {
        return ranting;
    }

    public void setRanting(int ranting) {
        this.ranting = ranting;
    }
}
