package com.torneos.LigaInterHospitales.repository;

import com.torneos.LigaInterHospitales.model.Torneo;
import com.torneos.LigaInterHospitales.model.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZonaRepository extends JpaRepository<Zona, Long> {

    List<Zona> findAllByTorneo(Torneo torneo);
}
