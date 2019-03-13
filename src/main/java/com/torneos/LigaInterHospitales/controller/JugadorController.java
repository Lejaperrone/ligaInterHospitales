package com.torneos.LigaInterHospitales.controller;

import com.torneos.LigaInterHospitales.dto.JugadorDto;
import com.torneos.LigaInterHospitales.exception.ResourceNotFoundException;
import com.torneos.LigaInterHospitales.model.Equipo;
import com.torneos.LigaInterHospitales.model.Jugador;
import com.torneos.LigaInterHospitales.repository.EquipoRepository;
import com.torneos.LigaInterHospitales.repository.JugadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class JugadorController {

    private JugadorRepository jugadorRepository;
    private ModelMapper modelMapper;
    private EquipoRepository equipoRepository;

    @Autowired
    public JugadorController(JugadorRepository jugadorRepository, ModelMapper modelMapper, EquipoRepository equipoRepository) {
        this.jugadorRepository = jugadorRepository;
        this.modelMapper = modelMapper;
        this.equipoRepository = equipoRepository;
    }

    @GetMapping("/jugadores")
    public List<JugadorDto> getAllJugadores() {

        return jugadorRepository.findAll().stream().map(jugador -> modelMapper.map(jugador, JugadorDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/jugador/{id}")
    public JugadorDto getJugadorById(@PathVariable(value = "id") Long id) {

        Jugador jugador = jugadorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Jugador", "Id", id));
        return modelMapper.map(jugador, JugadorDto.class);
    }

    @GetMapping("/jugadores/{idEquipo}")
    public List<JugadorDto> getJugadoresByEquipo(@PathVariable(value = "idEquipo" ) Long id) {
        Equipo equipo = equipoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equipo", "Id", id));
        List<Jugador> jugadores = jugadorRepository.findAllByEquipo(equipo);
        return jugadores.stream().map(jugador -> modelMapper.map(jugador, JugadorDto.class)).collect(Collectors.toList());
    }

    @PostMapping("/jugador")
    public JugadorDto crearJugador(@Valid @RequestBody JugadorDto jugadorDto) {

        Jugador jugador = modelMapper.map(jugadorDto, Jugador.class);

        jugadorRepository.save(jugador);

        return jugadorDto;
    }

    @PutMapping("/jugador/{id}")
    public JugadorDto updateJugador(@PathVariable(value = "id") Long id, @Valid @RequestBody JugadorDto jugadorUpdate) {

        Jugador jugador = jugadorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Jugador", "Id", id));

        jugador.setApellido(jugadorUpdate.getApellido());
        jugador.setDocumento(jugadorUpdate.getDocumento());
        jugador.setNombre(jugadorUpdate.getNombre());
        jugador.setEquipo(modelMapper.map(jugadorUpdate.getEquipo(), Equipo.class));

        jugadorRepository.save(jugador);

        return modelMapper.map(jugador, JugadorDto.class);
    }

    @DeleteMapping("/jugador/{id}")
    public ResponseEntity<?> deleteJugador(@PathVariable(value = "id") Long id) {
        Jugador jugador = jugadorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Jugador", "id", id));

        jugadorRepository.delete(jugador);

        return ResponseEntity.ok().build();
    }
}
