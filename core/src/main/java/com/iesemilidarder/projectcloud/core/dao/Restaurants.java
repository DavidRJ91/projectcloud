package com.iesemilidarder.projectcloud.core.dao;


import com.iesemilidarder.projectcloud.core.base.DBObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Restaurants extends DBObject {
    @Column(name="RES_CODI")
    private String codigo;

    @Column(name="RES_NOM")
    private String nombre;

    @Column(name="RES_ADRECA")
    private String direccion;

    @Column(name="RES_WEB")
    private String web;

    @Column(name="RES_TELEFON")
    private String telefono;

    @Column(name="TRS_DESCRIPCIO")
    private String descripcion;

    @Column(name="RES_URL_IMG")
    private String imagen;

    @Column(name="RES_MITJANA")
    private String media;

    @Column(name="RES_LATITUD")
    private String latitud;

    @Column(name="RES_LONGITUD")
    private String longitud;

    private ArrayList<Opiniones> opinions;


    public Restaurants() { this.opinions = new ArrayList<Opiniones>(); }

    public ArrayList<Opiniones> getOpinions() { return opinions; }
    public void setOpinions(ArrayList<Opiniones> opinions) { this.opinions = opinions; }

    /* Creamos los set y get */

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) { this.longitud = longitud; }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) { this.latitud = latitud; }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getMedia() { return media; }

    public void setMedia(String media) { this.media = media;}

    @Override
    protected void beforeSave() {
        doLog(String.format("Saving %s", this.getClass().getCanonicalName()));
        System.out.println("Saving users");
    }
}

/* David Rojas Julia */
/* 2ª ASIX */
