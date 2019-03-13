package com.torneos.LigaInterHospitales.controller;

import com.torneos.LigaInterHospitales.dto.EquipoDto;
import com.torneos.LigaInterHospitales.dto.JugadorDto;
import com.torneos.LigaInterHospitales.dto.ZonaDto;
import com.torneos.LigaInterHospitales.exception.ResourceNotFoundException;
import com.torneos.LigaInterHospitales.model.Equipo;
import com.torneos.LigaInterHospitales.model.Jugador;
import com.torneos.LigaInterHospitales.model.Zona;
import com.torneos.LigaInterHospitales.repository.EquipoRepository;
import com.torneos.LigaInterHospitales.repository.ZonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class EquipoController {

    private ModelMapper modelMapper;
    private EquipoRepository equipoRepository;
    private ZonaRepository zonaRepository;

    @Autowired
    public EquipoController(ModelMapper modelMapper, EquipoRepository equipoRepository, ZonaRepository zonaRepository) {

        this.modelMapper = modelMapper;
        this.equipoRepository = equipoRepository;
        this.zonaRepository = zonaRepository;
    }
    @GetMapping("/equipos")
    public List<EquipoDto> getAllEquipos(){
        return equipoRepository.findAll().stream().map(equipo ->modelMapper.map(equipo, EquipoDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/equipos/{idZona}")
    public List<EquipoDto>  getEquiposByZona(@PathVariable(value = "idZona" ) Long id){
        Zona zona = zonaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zona", "Id", id));
        List<Equipo> equipos = equipoRepository.findAllByZona(zona);
        return equipos.stream().map(equipo -> modelMapper.map(equipo,EquipoDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/equipo/{id}")
    public EquipoDto getEquipoById(@PathVariable(value = "id") Long id){
        Equipo equipo = equipoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equipo","Id",id));
        return modelMapper.map(equipo, EquipoDto.class);

    }

    @PostMapping("/equipo")
    public EquipoDto crearEquipo(@Valid @RequestBody EquipoDto equipoDto) {

        Equipo equipo = modelMapper.map(equipoDto, Equipo.class);

        equipoRepository.save(equipo);

        return equipoDto;
    }
    @PutMapping("/equipo/{id}")
    public EquipoDto updateEquipo(@PathVariable(value = "id") Long id,@Valid @RequestBody EquipoDto equipoUpdate){
        Equipo equipo = equipoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equipo", "Id", id));

        equipo.setNombre(equipoUpdate.getNombre());
        equipo.setZona(modelMapper.map(equipoUpdate.getZona(), Zona.class));

        equipoRepository.save(equipo);

        return modelMapper.map(equipo, EquipoDto.class);
    }

    @DeleteMapping("/equipo/{id}")
    public ResponseEntity<?> deleteEquipo(@PathVariable (value = "id") Long id){

        Equipo equipo = equipoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equipo", "Id", id));

        equipoRepository.delete(equipo);

        return ResponseEntity.ok().build();
    }
}