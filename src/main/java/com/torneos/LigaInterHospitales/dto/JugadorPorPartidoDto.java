package com.torneos.LigaInterHospitales.dto;

import java.io.Serializable;

public class JugadorPorPartidoDto implements Serializable {

    private Long id;

    private JugadorDto jugador;

    private PartidoDto partido;

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

    public JugadorDto getJugador() {
        return jugador;
    }

    public void setJugador(JugadorDto jugador) {
        this.jugador = jugador;
    }

    public PartidoDto getPartido() {
        return partido;
    }

    public void setPartido(PartidoDto partido) {
        this.partido = partido;
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
}
