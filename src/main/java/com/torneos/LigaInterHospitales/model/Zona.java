package com.torneos.LigaInterHospitales.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name = "Zona")
public class Zona implements Serializable {

    public Zona(){
    }

    public Zona(@NotBlank String nombre, Torneo torneo) {
        this.nombre = nombre;
        this.torneo = torneo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "torneo_id")
    private Torneo torneo;

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

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }
}
