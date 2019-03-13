package com.torneos.LigaInterHospitales.controller;

import com.torneos.LigaInterHospitales.dto.JugadorPorPartidoDto;
import com.torneos.LigaInterHospitales.exception.ResourceNotFoundException;
import com.torneos.LigaInterHospitales.model.Jugador;
import com.torneos.LigaInterHospitales.model.JugadorPorPartido;
import com.torneos.LigaInterHospitales.model.Partido;
import com.torneos.LigaInterHospitales.repository.JugadorPorPartidoRepository;
import com.torneos.LigaInterHospitales.repository.PartidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class JugadorPorPartidoController {

    private ModelMapper modelMapper;
    private PartidoRepository partidoRepository;
    private JugadorPorPartidoRepository jugadorPorPartidoRepository;

    @Autowired
    public JugadorPorPartidoController(ModelMapper modelMapper, PartidoRepository partidoRepository, JugadorPorPartidoRepository jugadorPorPartidoRepository) {
        this.modelMapper = modelMapper;
        this.partidoRepository = partidoRepository;
        this.jugadorPorPartidoRepository = jugadorPorPartidoRepository;
    }

    @GetMapping("jugadoresPorPartido/{idPartido}")
    public List<JugadorPorPartidoDto> getJugadoresPorPartidoByPartido(@PathVariable(value = "idPartido") Long id){

        Partido partido = partidoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Partido", "Id", id));

        List<JugadorPorPartido> jugadoresPorPartidos = jugadorPorPartidoRepository.findAllByPartido(partido);

        return jugadoresPorPartidos.stream().map( jugadorPorPartido -> modelMapper.map(jugadorPorPartido, JugadorPorPartidoDto.class)).collect(Collectors.toList());
    }

    @PostMapping("/jugadorPorPartido")
    public JugadorPorPartidoDto crearJugadorPorPartido(@Valid @RequestBody JugadorPorPartidoDto jugadorPorPartidoDto) {

        JugadorPorPartido jugadorPorPartido = modelMapper.map(jugadorPorPartidoDto, JugadorPorPartido.class);

        jugadorPorPartidoRepository.save(jugadorPorPartido);

        return modelMapper.map(jugadorPorPartido, JugadorPorPartidoDto.class);
    }

    @PutMapping("/jugadorPorPartido/{id}")
    public JugadorPorPartidoDto updateJugadorPorPartido(@PathVariable(value = "id") Long id, @Valid @RequestBody JugadorPorPartidoDto jugadorPorPartidoUpdate) {

        JugadorPorPartido jugadorPorPartido = jugadorPorPartidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("JugadorPorPartido", "Id", id));

        jugadorPorPartido.setAmarilla(jugadorPorPartidoUpdate.isAmarilla());
        jugadorPorPartido.setFigura(jugadorPorPartidoUpdate.isFigura());
        jugadorPorPartido.setNroCamiseta(jugadorPorPartidoUpdate.getNroCamiseta());
        jugadorPorPartido.setNroGoles(jugadorPorPartidoUpdate.getNroGoles());
        jugadorPorPartido.setRoja(jugadorPorPartidoUpdate.isRoja());
        jugadorPorPartido.setJugador(modelMapper.map(jugadorPorPartidoUpdate.getJugador(), Jugador.class));
        jugadorPorPartido.setPartido(modelMapper.map(jugadorPorPartidoUpdate.getPartido(), Partido.class));

        jugadorPorPartidoRepository.save(jugadorPorPartido);

        return modelMapper.map(jugadorPorPartido, JugadorPorPartidoDto.class);
    }

    @DeleteMapping("/jugadorPorPartido/{id}")
    public ResponseEntity<?> deleteJugadorPorPartido(@PathVariable(value = "id") Long id) {
        JugadorPorPartido jugadorPorPartido = jugadorPorPartidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("JugadorPorPartido", "id", id));

        jugadorPorPartidoRepository.delete(jugadorPorPartido);

        return ResponseEntity.ok().build();
    }
}