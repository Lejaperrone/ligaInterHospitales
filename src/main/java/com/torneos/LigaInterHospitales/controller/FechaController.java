package com.torneos.LigaInterHospitales.controller;


import com.torneos.LigaInterHospitales.repository.FechaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FechaController {

    private FechaRepository fechaRepository;

    public FechaController(FechaRepository fechaRepository){
        this.fechaRepository = fechaRepository;
    }

}
