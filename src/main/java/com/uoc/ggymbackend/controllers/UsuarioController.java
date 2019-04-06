package com.uoc.ggymbackend.controllers;

import com.uoc.ggymbackend.domain.vo.UsuarioVO;
import com.uoc.ggymbackend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/usuarios/crear", produces = "application/json", consumes = "application/json")
    public UsuarioVO crearUsuario(@RequestBody @Valid UsuarioVO usuarioVO) {
        return usuarioService.crearUsuario(usuarioVO);
    }

    @GetMapping(value = "/usuarios/{id}", produces = "application/json")
    public UsuarioVO obtenerUsuario(@PathVariable Long id) {
        return usuarioService.obtenerUsuario(id);
    }

    @PutMapping(value = "/usuarios/actualizar", produces = "application/json", consumes = "application/json")
    public void actualizarUsuario(@RequestBody @Valid UsuarioVO usuarioVO) {
        usuarioService.actualizarUsuario(usuarioVO);
    }

    @DeleteMapping(value = "/usuarios/{id}", produces = "application/json", consumes = "application/json")
    public void borrarUsuario(@PathVariable Long id) {
        usuarioService.borrarUsuario(id);
    }
}
