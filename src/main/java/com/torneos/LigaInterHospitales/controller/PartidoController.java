package com.torneos.LigaInterHospitales.controller;

import com.torneos.LigaInterHospitales.dto.PartidoDto;
import com.torneos.LigaInterHospitales.exception.ResourceNotFoundException;
import com.torneos.LigaInterHospitales.model.Equipo;
import com.torneos.LigaInterHospitales.model.Fecha;
import com.torneos.LigaInterHospitales.model.Partido;
import com.torneos.LigaInterHospitales.repository.EquipoRepository;
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
public class PartidoController {

    private ModelMapper modelMapper;
    private PartidoRepository partidoRepository;
    private EquipoRepository equipoRepository;

    @Autowired
    public PartidoController(ModelMapper modelMapper, PartidoRepository partidoRepository, EquipoRepository equipoRepository) {
        this.modelMapper = modelMapper;
        this.partidoRepository = partidoRepository;
        this.equipoRepository = equipoRepository;
    }

    @GetMapping("/partidos")
    public List<PartidoDto> getAllPartidos() {
        return partidoRepository.findAll().stream().map(partido -> modelMapper.map(partido, PartidoDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/partido/{id}")
    public PartidoDto getPartidoById(@PathVariable(value = "id") Long id) {
        Partido partido = partidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Partido", "Id", id));

        return modelMapper.map(partido, PartidoDto.class);
    }

    @GetMapping("/partidos/{idEquipo}")
    public List<PartidoDto> getPartidosByEquipo(@PathVariable(value = "idEquipo") Long id) {
        Equipo equipo = equipoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equipo", "Id", id));
        List<Partido> partidos = partidoRepository.findAllByLocalOrVisitante(equipo, equipo);
        return partidos.stream().map(partido -> modelMapper.map(partido, PartidoDto.class)).collect(Collectors.toList());
    }

    @PostMapping("/partido")
    public PartidoDto crearPartido(@Valid @RequestBody PartidoDto partidoDto) {

        Partido partido = modelMapper.map(partidoDto, Partido.class);

        partidoRepository.save(partido);

        return partidoDto;
    }

    @PutMapping("/partido/{id}")
    public PartidoDto updatePartido(@PathVariable(value = "id") Long id, @Valid @RequestBody PartidoDto partidoUpdate) {

        Partido partido = partidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Partido", "Id", id));

        partido.setGolesLocal(partidoUpdate.getGolesLocal());
        partido.setGolesVisita(partidoUpdate.getGolesVisita());
        partido.setLocal(modelMapper.map(partidoUpdate.getLocal(), Equipo.class));
        partido.setVisitante(modelMapper.map(partidoUpdate.getVisitante(), Equipo.class));
        partido.setFecha(modelMapper.map(partidoUpdate.getFecha(), Fecha.class));

        partidoRepository.save(partido);

        return modelMapper.map(partido, PartidoDto.class);
    }

    @DeleteMapping("/partido/{id}")
    public ResponseEntity<?> deletePartido(@PathVariable(value = "id") Long id) {
        Partido partido = partidoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Partido", "id", id));

        partidoRepository.delete(partido);

        return ResponseEntity.ok().build();
    }
}
