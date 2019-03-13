package com.torneos.LigaInterHospitales.repository;

import com.torneos.LigaInterHospitales.model.Equipo;
import com.torneos.LigaInterHospitales.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
    List<Partido> findAllByLocalOrVisitante(Equipo equipo1, Equipo equipo2);
}
