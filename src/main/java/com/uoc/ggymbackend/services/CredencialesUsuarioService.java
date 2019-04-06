package com.uoc.ggymbackend.services;

import com.uoc.ggymbackend.domain.CredencialesUsuario;
import com.uoc.ggymbackend.domain.vo.CredencialesUsuarioVO;
import com.uoc.ggymbackend.repositories.CredencialesUsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CredencialesUsuarioService {

    @Autowired
    private CredencialesUsuarioRepository credencialesUsuarioRepository;

    @Autowired
    private ModelMapper modelMapper;


    public CredencialesUsuarioVO crearCredenciales(CredencialesUsuarioVO credencialesUsuarioVO) {
        // Mapear a entidad
        CredencialesUsuario credencialesUsuario = modelMapper.map(credencialesUsuarioVO, CredencialesUsuario.class);
        // Guardar
        credencialesUsuario = credencialesUsuarioRepository.save(credencialesUsuario);
        // Mapear a VO y devolver
        return modelMapper.map(credencialesUsuario, CredencialesUsuarioVO.class);
    }

    public CredencialesUsuarioVO login(String email, String password) {
        // Obtener el usuario solicitado
        CredencialesUsuario optCredencialesUsuario = credencialesUsuarioRepository.findByEmailIgnoreCaseAndPassword(email, password);
        if(optCredencialesUsuario == null) {
            throw new NoSuchElementException("No se encuentra el usuario solicitado");
        }
        // Mapear el usuario a VO y devolverlo
        return modelMapper.map(optCredencialesUsuario, CredencialesUsuarioVO.class);
    }

    public void actualizarCredenciales(CredencialesUsuarioVO credencialesUsuarioVO) {
        // Comprobar si existe
        Optional<CredencialesUsuario> credencialesOpt =  credencialesUsuarioRepository.findById(credencialesUsuarioVO.getEmail());
        if(!credencialesOpt.isPresent()) {
            throw new NoSuchElementException("No se encuentra el usuario solicitado");
        }
        // Mapear cambios y guardar
        CredencialesUsuario credencialesUsuario = credencialesOpt.get();
        credencialesUsuario.setEmail(credencialesUsuarioVO.getEmail());
        credencialesUsuario.setPassword(credencialesUsuarioVO.getPassword());
        credencialesUsuarioRepository.saveAndFlush(credencialesUsuario);
    }
}
