package com.laialechma.petagram;

/**
 * Created by Laia Lechma on 15/05/2016.
 */
public class Detalle {

    private String nombre;
    private String tipo;
    private String raza;
    private String localizacion;
    private String frase;

    public Detalle(String nombre, String tipo, String raza, String localizacion, String frase) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.raza = raza;
        this.localizacion = localizacion;
        this.frase = frase;
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
}
