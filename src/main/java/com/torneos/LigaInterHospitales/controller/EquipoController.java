package com.torneos.LigaInterHospitales.controller;

import com.torneos.LigaInterHospitales.dto.EquipoDto;
import com.torneos.LigaInterHospitales.exception.ResourceNotFoundException;
import com.torneos.LigaInterHospitales.model.Equipo;
import com.torneos.LigaInterHospitales.model.Zona;
import com.torneos.LigaInterHospitales.repository.EquipoRepository;
import com.torneos.LigaInterHospitales.repository.ZonaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping(value = "/equipos")
    public List<EquipoDto> getAllEquipos(){
        return equipoRepository.findAll().stream().map(equipo ->modelMapper.map(equipo, EquipoDto.class)).collect(Collectors.toList());
    }

    @GetMapping(value = "/equipos/{idZona}")
    public List<EquipoDto>  getEquiposByZona(@PathVariable(value = "idZona" ) Long id){
        Zona zona = zonaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zona", "Id", id));
        List<Equipo> equipos = equipoRepository.findAllByZona(zona);
        return equipos.stream().map(equipo -> modelMapper.map(equipo,EquipoDto.class)).collect(Collectors.toList());
    }
}