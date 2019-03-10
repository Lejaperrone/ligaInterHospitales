package com.torneos.LigaInterHospitales.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Jugador")
public class Jugador implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    private int documento;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador")
    private List<JugadorPorPartido> jugadorPorPartidos;

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

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public List<JugadorPorPartido> getJugadorPorPartidos() {
        return jugadorPorPartidos;
    }

    public void setJugadorPorPartidos(List<JugadorPorPartido> jugadorPorPartidos) {
        this.jugadorPorPartidos = jugadorPorPartidos;
    }
}
