package com.torneos.LigaInterHospitales.repository;

import com.torneos.LigaInterHospitales.model.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneoRepository extends JpaRepository<Torneo, Long> {
}
