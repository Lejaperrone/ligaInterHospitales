package com.torneos.LigaInterHospitales.dto;

import java.io.Serializable;

public class ZonaDto implements Serializable {

    private Long id;

    private String nombre;

    private TorneoDto torneo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TorneoDto getTorneo() {
        return torneo;
    }

    public void setTorneo(TorneoDto torneo) {
        this.torneo = torneo;
    }
}
