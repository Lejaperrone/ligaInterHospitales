package com.torneos.LigaInterHospitales.repository;

import com.torneos.LigaInterHospitales.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long> {


}
