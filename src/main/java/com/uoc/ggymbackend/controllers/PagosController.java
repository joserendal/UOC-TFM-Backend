package com.uoc.ggymbackend.controllers;

import com.uoc.ggymbackend.domain.vo.PagosAbonadoVO;
import com.uoc.ggymbackend.services.PagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PagosController {

    @Autowired
    private PagosService pagosService;

    @PostMapping(value = "/pagos/crear", produces = "application/json", consumes = "application/json")
    public PagosAbonadoVO crearPagos(@RequestBody @Valid PagosAbonadoVO pagosAbonadoVO) {
        return pagosService.crearPagos(pagosAbonadoVO);
    }

    @GetMapping(value = "/pagos/pendientes/{idCentroDeportivo}/{mes}/{anio}", produces = "application/json")
    public List<PagosAbonadoVO> obtenerListadoPagosPendientes(@PathVariable Long idCentroDeportivo,
                                                              @PathVariable int mes, @PathVariable int anio) {
        return pagosService.obtenerListadoPagosPendientes(idCentroDeportivo, mes, anio);
    }

    @GetMapping(value = "/pagos/abonados/{idCentroDeportivo}/{mes}/{anio}", produces = "application/json")
    public List<PagosAbonadoVO> obtenerListadoPagosAbonados(@PathVariable Long idCentroDeportivo,
                                                            @PathVariable int mes, @PathVariable int anio) {
        return pagosService.obtenerListadoPagosAbonados(idCentroDeportivo, mes, anio);
    }

    @GetMapping(value = "/pagos/{id}", produces = "application/json")
    public PagosAbonadoVO obtenerPago(@PathVariable Long id) {
        return pagosService.obtenerPago(id);
    }

}
