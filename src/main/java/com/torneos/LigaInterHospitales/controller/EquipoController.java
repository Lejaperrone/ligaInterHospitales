package com.torneos.LigaInterHospitales.controller;

import com.torneos.LigaInterHospitales.dto.EquipoDto;
import com.torneos.LigaInterHospitales.repository.EquipoRepository;
import com.torneos.LigaInterHospitales.repository.JugadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class EquipoController {

    private ModelMapper modelMapper;
    private EquipoRepository equipoRepository;

    @Autowired
    public EquipoController(ModelMapper modelMapper, EquipoRepository equipoRepository) {

        this.modelMapper = modelMapper;
        this.equipoRepository = equipoRepository;
    }
    @GetMapping(value = "/equipos")
    public List<EquipoDto> getAllEquipos(){
        return equipoRepository.findAll().stream().map(equipo ->modelMapper.map(equipo, EquipoDto.class)).collect(Collectors.toList());
    }

}
