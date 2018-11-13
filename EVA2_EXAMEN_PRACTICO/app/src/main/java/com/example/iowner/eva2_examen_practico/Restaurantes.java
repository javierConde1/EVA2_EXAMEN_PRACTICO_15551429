package com.example.iowner.eva2_examen_practico;

import java.io.Serializable;

public class Restaurantes implements Serializable {
    private String sNombre;
    private String sDescripcion;
    private String sDireccionTelefono;
    private int iImagen;
    private int iOpinion;

    public Restaurantes(String nom, String des, String dir, int img, int opinion){
        setsNombre(nom);
        setsDescripcion(des);
        setsDireccionTelefono(dir);
        setiImagen(img);
        setiOpinion(opinion);
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getsDescripcion() {
        return sDescripcion;
    }

    public void setsDescripcion(String sDescripcion) {
        this.sDescripcion = sDescripcion;
    }

    public String getsDireccionTelefono() {
        return sDireccionTelefono;
    }

    public void setsDireccionTelefono(String sDireccionTelefono) {
        this.sDireccionTelefono = sDireccionTelefono;
    }

    public int getiImagen() {
        return iImagen;
    }

    public void setiImagen(int iImagen) {
        this.iImagen = iImagen;
    }

    public int getiOpinion() {
        return iOpinion;
    }

    public void setiOpinion(int iOpinion) {
        this.iOpinion = iOpinion;
    }
}
