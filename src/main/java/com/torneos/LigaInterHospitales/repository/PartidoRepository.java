package com.torneos.LigaInterHospitales.repository;

import com.torneos.LigaInterHospitales.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
}
