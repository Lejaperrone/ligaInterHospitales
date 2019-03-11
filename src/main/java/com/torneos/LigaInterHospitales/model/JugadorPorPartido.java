package com.torneos.LigaInterHospitales.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "JugadorPorPartido")
public class JugadorPorPartido implements Serializable {

    public JugadorPorPartido(){

    }

    public JugadorPorPartido(Jugador jugador, Partido partido, int nroCamiseta, int nroGoles, boolean amarilla, boolean roja, boolean figura) {
        this.jugador = jugador;
        this.partido = partido;
        this.nroCamiseta = nroCamiseta;
        this.nroGoles = nroGoles;
        this.amarilla = amarilla;
        this.roja = roja;
        this.figura = figura;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "jugador_id")
    private Jugador jugador;

    @ManyToOne()
    @JoinColumn(name = "partido_id")
    private Partido partido;

    private int nroCamiseta;

    private int nroGoles;

    private boolean amarilla;

    private boolean roja;

    private boolean figura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getNroCamiseta() {
        return nroCamiseta;
    }

    public void setNroCamiseta(int nroCamiseta) {
        this.nroCamiseta = nroCamiseta;
    }

    public int getNroGoles() {
        return nroGoles;
    }

    public void setNroGoles(int nroGoles) {
        this.nroGoles = nroGoles;
    }

    public boolean isAmarilla() {
        return amarilla;
    }

    public void setAmarilla(boolean amarilla) {
        this.amarilla = amarilla;
    }

    public boolean isRoja() {
        return roja;
    }

    public void setRoja(boolean roja) {
        this.roja = roja;
    }

    public boolean isFigura() {
        return figura;
    }

    public void setFigura(boolean figura) {
        this.figura = figura;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
}
