package com.torneos.LigaInterHospitales.repository;

import com.torneos.LigaInterHospitales.model.Equipo;
import com.torneos.LigaInterHospitales.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Serializable> {
    List<Jugador> findAllByEquipo(Equipo equipo);
}
