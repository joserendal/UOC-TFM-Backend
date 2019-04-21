package com.uoc.ggymbackend.controllers;

import com.uoc.ggymbackend.domain.vo.CredencialesUsuarioVO;
import com.uoc.ggymbackend.services.CredencialesUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CredencialesUsuarioController {

    @Autowired
    private CredencialesUsuarioService credencialesUsuarioService;

    @PostMapping(value = "/credenciales/crear", produces = "application/json", consumes = "application/json")
    public void registrarLogin(@RequestBody @Valid CredencialesUsuarioVO credencialesUsuarioVO) {
        credencialesUsuarioService.crearCredenciales(credencialesUsuarioVO);
    }

    @PostMapping(value = "/credenciales/login", produces = "application/json")
    public CredencialesUsuarioVO login(@RequestBody @Valid CredencialesUsuarioVO credencialesUsuarioVO) {
        return credencialesUsuarioService.login(credencialesUsuarioVO.getEmail(), credencialesUsuarioVO.getPassword());
    }

    @PutMapping(value = "/credenciales/actualizar", produces = "application/json", consumes = "application/json")
    public void actualizarCredenciales(@RequestBody @Valid CredencialesUsuarioVO credencialesUsuarioVO) {
        credencialesUsuarioService.actualizarCredenciales(credencialesUsuarioVO);
    }
}
