package com.torneos.LigaInterHospitales.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Zona")
public class Zona implements Serializable {

    public Zona(){
    }

    public Zona(@NotBlank String nombre, List<Equipo> equipos, Torneo torneo, List<Fecha> fecha) {
        this.nombre = nombre;
        this.equipos = equipos;
        this.torneo = torneo;
        this.fecha = fecha;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @OneToMany(mappedBy = "zona")
    private List<Equipo> equipos;

    @ManyToOne
    @JoinColumn(name = "torneo_id")
    private Torneo torneo;

    @OneToMany(mappedBy = "zona")
    private List<Fecha> fecha;

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

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public List<Fecha> getFecha() {
        return fecha;
    }

    public void setFecha(List<Fecha> fecha) {
        this.fecha = fecha;
    }
}
