package com.torneos.LigaInterHospitales.repository;

import com.torneos.LigaInterHospitales.model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
