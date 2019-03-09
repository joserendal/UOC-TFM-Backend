package com.uoc.ggymbackend.controllers;

import com.uoc.ggymbackend.domain.CredencialesUsuario;
import com.uoc.ggymbackend.domain.vo.CredencialesUsuarioVO;
import com.uoc.ggymbackend.domain.vo.UsuarioVO;
import com.uoc.ggymbackend.services.mapper.CredencialesUsuarioService;
import com.uoc.ggymbackend.services.mapper.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CredencialesUsuarioController {

    @Autowired
    private CredencialesUsuarioService credencialesUsuarioService;

    @PostMapping(value = "/credenciales", produces = "application/json", consumes = "application/json")
    public CredencialesUsuarioVO registrarLogin(@RequestBody @Valid CredencialesUsuarioVO credencialesUsuarioVO) {
        return credencialesUsuarioService.crearCredenciales(credencialesUsuarioVO);
    }

    @PostMapping(value = "/login", produces = "application/json")
    public CredencialesUsuarioVO login(@RequestParam String email, @RequestParam String password) {
        return credencialesUsuarioService.login(email, password);
    }

    @PutMapping(value = "/credenciales", produces = "application/json", consumes = "application/json")
    public void actualizarCredenciales(@RequestBody @Valid CredencialesUsuarioVO credencialesUsuarioVO) {
        credencialesUsuarioService.actualizarCredenciales(credencialesUsuarioVO);
    }
}
