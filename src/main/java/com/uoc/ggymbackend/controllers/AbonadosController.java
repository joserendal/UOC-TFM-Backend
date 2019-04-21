package com.uoc.ggymbackend.controllers;

import com.uoc.ggymbackend.domain.vo.AbonadoVO;
import com.uoc.ggymbackend.services.AbonadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AbonadosController {

    @Autowired
    private AbonadosService abonadosService;

    @PostMapping(value = "/abonados/crear", produces = "application/json", consumes = "application/json")
    public AbonadoVO crearAbonado(@RequestBody @Valid AbonadoVO abonadoVO) {
        return abonadosService.crearAbonado(abonadoVO);
    }

    @GetMapping(value = "/abonados/centro/{idCentroDeportivo}", produces = "application/json")
    public List<AbonadoVO> obtenerListadoAbonados(@PathVariable Long idCentroDeportivo) {
        return abonadosService.obtenerListadoAbonados(idCentroDeportivo);
    }

    @GetMapping(value = "/abonados/{id}", produces = "application/json")
    public AbonadoVO obtenerAbonado(@PathVariable Long id) {
        return abonadosService.obtenerAbonado(id);
    }

    @PutMapping(value = "/abonados/actualizar", produces = "application/json", consumes = "application/json")
    public void actualizarAbonado(@RequestBody @Valid AbonadoVO abonadoVO) {
        abonadosService.actualizarAbonado(abonadoVO);
    }

    @DeleteMapping(value = "/abonados/{id}", produces = "application/json")
    public void borrarAbonado(@PathVariable Long id) {
        abonadosService.borrarAbonado(id);
    }

}

