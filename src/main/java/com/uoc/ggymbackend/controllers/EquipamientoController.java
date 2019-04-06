package com.uoc.ggymbackend.controllers;

import com.uoc.ggymbackend.domain.vo.EquipamientoVO;
import com.uoc.ggymbackend.domain.vo.ReservaVO;
import com.uoc.ggymbackend.services.EquipamientosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class EquipamientoController {

    @Autowired
    private EquipamientosService equipamientosService;

    @PostMapping(value = "/equipamiento/crear", produces = "application/json", consumes = "application/json")
    public EquipamientoVO crearEquipamiento(@RequestBody @Valid EquipamientoVO equipamientoVO) {
        return equipamientosService.crearEquipamiento(equipamientoVO);
    }

    @GetMapping(value = "/equipamiento/{id}", produces = "application/json")
    public EquipamientoVO obtenerEquipamiento(@PathVariable Long id) {
        return equipamientosService.obtenerEquipamiento(id);
    }

    @PutMapping(value = "/equipamiento/actualizar", produces = "application/json", consumes = "application/json")
    public void actualizarEquipamiento(@RequestBody @Valid EquipamientoVO equipamientoVO) {
        equipamientosService.actualizarEquipamiento(equipamientoVO);
    }

    @PostMapping(value = "/equipamiento/reservar/", produces = "application/json", consumes = "application/json")
    public void reservarEquipamiento(@RequestBody @Valid ReservaVO reservaVO) {
        equipamientosService.reservarEquipamiento(reservaVO);
    }


}
