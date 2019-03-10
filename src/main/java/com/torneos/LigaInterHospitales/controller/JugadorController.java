package com.torneos.LigaInterHospitales.controller;


import com.torneos.LigaInterHospitales.model.Jugador;
import com.torneos.LigaInterHospitales.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class JugadorController {

    @Autowired
    JugadorRepository jugadorRepository;

    @GetMapping("/jugadores")
    public List<Jugador> getAllJugadores() {
        return jugadorRepository.findAll();
    }

    @PostMapping("/jugador")
    public Jugador crearJugador(@Valid @RequestBody Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

}
