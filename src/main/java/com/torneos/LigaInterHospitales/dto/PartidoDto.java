package com.torneos.LigaInterHospitales.dto;

import java.io.Serializable;

public class PartidoDto implements Serializable {

    private Long id;

    private EquipoDto local;

    private EquipoDto visitante;

    private FechaDto fecha;

    private int golesLocal;

    private int golesVisita;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EquipoDto getLocal() {
        return local;
    }

    public void setLocal(EquipoDto local) {
        this.local = local;
    }

    public EquipoDto getVisitante() {
        return visitante;
    }

    public void setVisitante(EquipoDto visitante) {
        this.visitante = visitante;
    }

    public FechaDto getFecha() {
        return fecha;
    }

    public void setFecha(FechaDto fecha) {
        this.fecha = fecha;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisita() {
        return golesVisita;
    }

    public void setGolesVisita(int golesVisita) {
        this.golesVisita = golesVisita;
    }
}
