package com.uoc.ggymbackend.controllers;

import com.uoc.ggymbackend.domain.vo.CentroDeportivoVO;
import com.uoc.ggymbackend.services.CentrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CentrosController {

    @Autowired
    private CentrosService centrosService;

    @PostMapping(value = "/centros/crear", produces = "application/json", consumes = "application/json")
    public CentroDeportivoVO crearCentroDeportivo(@RequestBody @Valid CentroDeportivoVO centroDeportivoVO) {
        return centrosService.crearCentro(centroDeportivoVO);
    }

    @GetMapping(value = "/centros/{id}", produces = "application/json")
    public CentroDeportivoVO obtenerCentroDeportivo(@PathVariable Long id) {
        return centrosService.obtenerCentro(id);
    }

    @PutMapping(value = "/centros/actualizar", produces = "application/json", consumes = "application/json")
    public void actualizarCentroDeportivo(@RequestBody @Valid CentroDeportivoVO centroDeportivoVO) {
        centrosService.actualizarCentro(centroDeportivoVO);
    }

    @DeleteMapping(value = "/centros/{id}", produces = "application/json", consumes = "application/json")
    public void borrarCentroDeportivo(@PathVariable Long id) {
        centrosService.borrarCentro(id);
    }

}
