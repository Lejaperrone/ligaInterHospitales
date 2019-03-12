package com.torneos.LigaInterHospitales.dto;

import java.io.Serializable;

public class EquipoDto implements Serializable {

    private Long id;

    private String nombre;

    private ZonaDto zona;

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

    public ZonaDto getZona() {
        return zona;
    }

    public void setZona(ZonaDto zona) {
        this.zona = zona;
    }
}
