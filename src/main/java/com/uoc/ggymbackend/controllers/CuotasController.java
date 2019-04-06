package com.uoc.ggymbackend.controllers;

import com.uoc.ggymbackend.domain.vo.CuotaAbonadoVO;
import com.uoc.ggymbackend.services.CuotasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CuotasController {

    @Autowired
    private CuotasService cuotasService;

    @PostMapping(value = "/cuotas/crear", produces = "application/json", consumes = "application/json")
    public CuotaAbonadoVO crearCuota(@RequestBody @Valid CuotaAbonadoVO cuotaAbonadoVO) {
        return cuotasService.crearCuota(cuotaAbonadoVO);
    }

    @GetMapping(value = "/cuotas/{id}", produces = "application/json")
    public CuotaAbonadoVO obtenerCuota(@PathVariable Long id) {
        return cuotasService.obtenerCuota(id);
    }

    @PutMapping(value = "/cuotas/actualizar", produces = "application/json", consumes = "application/json")
    public void actualizarCuota(@RequestBody @Valid CuotaAbonadoVO cuotaAbonadoVO) {
        cuotasService.actualizarCuota(cuotaAbonadoVO);
    }

    @DeleteMapping(value = "/cuotas/{id}", produces = "application/json", consumes = "application/json")
    public void borrarCuota(@PathVariable Long id) {
        cuotasService.borrarCuota(id);
    }

}
