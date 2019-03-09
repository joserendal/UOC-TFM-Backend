package com.uoc.ggymbackend.services.mapper;

import com.uoc.ggymbackend.domain.Usuario;
import com.uoc.ggymbackend.domain.vo.UsuarioVO;
import com.uoc.ggymbackend.repositories.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ModelMapper modelMapper;

    public UsuarioVO crearUsuario(UsuarioVO usuarioVO) {
        // Mapear a entidad
        Usuario usuario = modelMapper.map(usuarioVO, Usuario.class);
        // Guardar
        usuario = usuarioRepository.save(usuario);
        // Mapear a VO y devolver
        return modelMapper.map(usuario, UsuarioVO.class);
    }

    public UsuarioVO obtenerUsuario(Long idUsuario) {
        // Obtener el usuario solicitado
        Optional<Usuario> optUsuario = usuarioRepository.findById(idUsuario);
        if(!optUsuario.isPresent()) {
            throw new NoSuchElementException("No se encuentra el usuario solicitado");
        }
        // Mapear el usuario a VO y devolverlo
        return modelMapper.map(optUsuario.get(), UsuarioVO.class);
    }

    public void actualizarUsuario(UsuarioVO usuarioVO) {
        // Mapear el usuario a entidad
        Usuario usuario = modelMapper.map(usuarioVO, Usuario.class);
        // Comprobar si existe
        Optional<Usuario> optUsuario = usuarioRepository.findById(usuario.getIdUsuario());
        if(!optUsuario.isPresent()) {
            throw new NoSuchElementException("No se encuentra el usuario solicitado");
        }
        // Actualizar el usuario
        usuarioRepository.saveAndFlush(usuario);
    }

    public void borrarUsuario(Long idUsuario) {
        // Obtener el usuario
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if(!usuario.isPresent()) {
            throw new NoSuchElementException("No se encuentra el usuario solicitado");
        }
        // Borrar el usuario
        usuarioRepository.deleteById(idUsuario);
    }
 }
