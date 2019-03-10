package com.torneos.LigaInterHospitales.repository;

import com.torneos.LigaInterHospitales.model.JugadorPorPartido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorPorPartidoRepository extends JpaRepository<JugadorPorPartido, Long> {
}
