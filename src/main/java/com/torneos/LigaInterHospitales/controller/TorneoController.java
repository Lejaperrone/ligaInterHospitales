package com.torneos.LigaInterHospitales.controller;

import com.torneos.LigaInterHospitales.dto.TorneoDto;
import com.torneos.LigaInterHospitales.exception.ResourceNotFoundException;
import com.torneos.LigaInterHospitales.model.Torneo;
import com.torneos.LigaInterHospitales.repository.TorneoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class TorneoController {

    private ModelMapper modelMapper;
    private TorneoRepository torneoRepository;

    @Autowired
    public TorneoController(ModelMapper modelMapper, TorneoRepository torneoRepository) {
        this.modelMapper = modelMapper;
        this.torneoRepository = torneoRepository;
    }

    @GetMapping("/torneos")
    public List<TorneoDto> getAllTorneos() {
        return torneoRepository.findAll().stream().map(torneo -> modelMapper.map(torneo, TorneoDto.class)).collect(Collectors.toList());
    }

    @GetMapping("/torneo/{id}")
    public TorneoDto getTorneoById(@PathVariable(value = "id") Long id) {

        Torneo torneo = torneoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Torneo", "Id", id));

        return modelMapper.map(torneo, TorneoDto.class);
    }

    @PostMapping("/torneo")
    public TorneoDto crearTorneo(@Valid @RequestBody TorneoDto torneoDto) {

        Torneo torneo = modelMapper.map(torneoDto, Torneo.class);

        torneoRepository.save(torneo);

        return modelMapper.map(torneo, TorneoDto.class);
    }

    @PutMapping("/torneo/{id}")
    public TorneoDto updateTorneo(@PathVariable(value = "id") Long id, @Valid @RequestBody TorneoDto torneoUpdate) {

        Torneo torneo = torneoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Torneo", "Id", id));

        torneo.setNombre(torneoUpdate.getNombre());

        torneoRepository.save(torneo);

        return modelMapper.map(torneo, TorneoDto.class);
    }

    @DeleteMapping("/torneo/{id}")
    public ResponseEntity<?> deleteTorneo(@PathVariable(value = "id") Long id) {
        Torneo torneo = torneoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Torneo", "id", id));

        torneoRepository.delete(torneo);

        return ResponseEntity.ok().build();
    }

}
