package com.torneos.LigaInterHospitales.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Partido")
public class Partido implements Serializable {

    public Partido(){
    }

    public Partido(Equipo local, Equipo visitante, Fecha fecha, int golesLocal, int golesVisita) {
        this.local = local;
        this.visitante = visitante;
        this.fecha = fecha;
        this.golesLocal = golesLocal;
        this.golesVisita = golesVisita;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "local_id")
    private Equipo local;

    @ManyToOne()
    @JoinColumn(name = "visita_id")
    private Equipo visitante;

    @ManyToOne()
    @JoinColumn(name = "fecha_id")
    private Fecha fecha;

    private int golesLocal;

    private int golesVisita;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
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
