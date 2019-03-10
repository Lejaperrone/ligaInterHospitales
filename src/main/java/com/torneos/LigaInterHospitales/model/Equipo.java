package com.torneos.LigaInterHospitales.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Equipo")
public class Equipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @OneToMany(mappedBy = "equipo")
    private List<Jugador> jugadores;

    @ManyToOne
    @JoinColumn(name = "zona_id")
    private Zona zona;

    @OneToMany(mappedBy = "local")
    private List<Partido> partidosLocales;

    @OneToMany(mappedBy = "visitante")
    private List<Partido> partidosVisitantes;

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

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public List<Partido> getPartidosLocales() {
        return partidosLocales;
    }

    public void setPartidosLocales(List<Partido> partidosLocales) {
        this.partidosLocales = partidosLocales;
    }

    public List<Partido> getPartidosVisitantes() {
        return partidosVisitantes;
    }

    public void setPartidosVisitantes(List<Partido> partidosVisitantes) {
        this.partidosVisitantes = partidosVisitantes;
    }
}
