package com.torneos.LigaInterHospitales.repository;

import com.torneos.LigaInterHospitales.model.JugadorPorPartido;
import com.torneos.LigaInterHospitales.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorPorPartidoRepository extends JpaRepository<JugadorPorPartido, Long> {

    List<JugadorPorPartido> findAllByPartido(Partido partido);
}
