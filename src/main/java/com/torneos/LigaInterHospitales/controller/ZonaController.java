package com.torneos.LigaInterHospitales.controller;

import com.torneos.LigaInterHospitales.dto.TorneoDto;
import com.torneos.LigaInterHospitales.dto.ZonaDto;
import com.torneos.LigaInterHospitales.exception.ResourceNotFoundException;
import com.torneos.LigaInterHospitales.model.Torneo;
import com.torneos.LigaInterHospitales.model.Zona;
import com.torneos.LigaInterHospitales.repository.TorneoRepository;
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
public class ZonaController {

    private ModelMapper modelMapper;
    private ZonaRepository zonaRepository;
    private TorneoRepository torneoRepository;

    @Autowired
    public ZonaController(ModelMapper modelMapper, ZonaRepository zonaRepository, TorneoRepository torneoRepository) {
        this.modelMapper = modelMapper;
        this.zonaRepository = zonaRepository;
        this.torneoRepository = torneoRepository;
    }

    @GetMapping("/zonas")
    public List<ZonaDto> getAllZonas() {
        return zonaRepository.findAll().stream().map(zona -> modelMapper.map(zona, ZonaDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/zonas/{idTorneo}")
    public List<ZonaDto> getAllZonasByRepository(@PathVariable(value = "idTorneo") Long id) {

        Torneo torneo = torneoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Torneo", "id", id));

        List<Zona> zonas = zonaRepository.findAllByTorneo(torneo);

        return zonas.stream().map(zona -> modelMapper.map(zona, ZonaDto.class)).collect(Collectors.toList());
    }

    @PostMapping("/zona")
    public ZonaDto crearZona(@Valid @RequestBody ZonaDto zonaDto) {

        Zona zona = modelMapper.map(zonaDto, Zona.class);

        zonaRepository.save(zona);

        return modelMapper.map(zona, ZonaDto.class);
    }

    @PutMapping("/zona/{id}")
    public ZonaDto updateZona(@PathVariable(value = "id") Long id, @Valid @RequestBody ZonaDto zonaUpdate) {

        Zona zona = zonaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zona", "Id", id));

        zona.setNombre(zonaUpdate.getNombre());
        zona.setTorneo(modelMapper.map(zonaUpdate.getTorneo(), Torneo.class));

        zonaRepository.save(zona);

        return modelMapper.map(zona, ZonaDto.class);
    }

    @DeleteMapping("/zona/{id}")
    public ResponseEntity<?> deleteZona(@PathVariable(value = "id") Long id) {
        Zona zona = zonaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Zona", "id", id));

        zonaRepository.delete(zona);

        return ResponseEntity.ok().build();
    }
}
