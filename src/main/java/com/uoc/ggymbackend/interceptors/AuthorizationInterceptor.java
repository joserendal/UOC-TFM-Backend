package com.uoc.ggymbackend.interceptors;

import com.uoc.ggymbackend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.NoSuchElementException;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Comprobar que existe la cabecera idUsuario
        String idUsuario = request.getHeader("idUsuario");
        // Si no existe la cabecera no dejaremos pasar
        if (idUsuario == null || idUsuario.isEmpty()) {
            return false;
        }
        // Comprobar que el usuario existe llamando al service.
        try {
            usuarioService.obtenerUsuario(Long.parseLong(idUsuario));
        } catch (NoSuchElementException e) {
            // El usuario no existe. No dejaremos pasar.
            return false;
        }

        return true;
    }
}
