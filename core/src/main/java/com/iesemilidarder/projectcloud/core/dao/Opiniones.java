package com.iesemilidarder.projectcloud.core.dao;

/* Creamos los set y get */

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Opiniones {
    @Column(name = "OPI_OBSERVACIO")
    private String observacion;
    @Column(name = "OPI_PUNTUACIO")
    private String puntuacion;
    @Column(name = "USU_NOM")
    private String nombreUsu;

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) { this.nombreUsu = nombreUsu; }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) { this.puntuacion = puntuacion; }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) { this.observacion = observacion; }
}

/* David Rojas Julia */
/* 2ª ASIX */