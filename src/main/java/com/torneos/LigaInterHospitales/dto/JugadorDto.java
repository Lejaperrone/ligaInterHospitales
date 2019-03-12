package com.torneos.LigaInterHospitales.dto;

import java.io.Serializable;

public class JugadorDto implements Serializable
{
    private Long id;

    private String nombre;

    private String apellido;

    private int documento;

    private EquipoDto equipo;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public EquipoDto getEquipo() {
        return equipo;
    }

    public void setEquipo(EquipoDto equipo) {
        this.equipo = equipo;
    }
}
