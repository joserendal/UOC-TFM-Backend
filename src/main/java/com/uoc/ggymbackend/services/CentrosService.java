package com.uoc.ggymbackend.services;

import com.uoc.ggymbackend.domain.CentroDeportivo;
import com.uoc.ggymbackend.domain.Usuario;
import com.uoc.ggymbackend.domain.vo.CentroDeportivoVO;
import com.uoc.ggymbackend.domain.vo.UsuarioVO;
import com.uoc.ggymbackend.repositories.CentroDeportivoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CentrosService {

    @Autowired
    private CentroDeportivoRepository centroDeportivoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ModelMapper modelMapper;

    public CentroDeportivoVO crearCentro(CentroDeportivoVO centroDeportivoVO) {
        // Mapear a entidad
        CentroDeportivo centroDeportivo = modelMapper.map(centroDeportivoVO, CentroDeportivo.class);
        // Obtener los datos del usuario
        UsuarioVO usuarioVO = usuarioService.obtenerUsuario(centroDeportivoVO.getIdGestor());
        Usuario usuario = modelMapper.map(usuarioVO, Usuario.class);
        centroDeportivo.setGestor(usuario);
        // Guardar en la base de datos
        centroDeportivo = centroDeportivoRepository.save(centroDeportivo);
        // Mapear a VO y devolver
        return modelMapper.map(centroDeportivo, CentroDeportivoVO.class);
    }

    public CentroDeportivoVO obtenerCentro(Long idCentroDeportivo) {
        // Obtener el centro deportivo solicitado
        Optional<CentroDeportivo> optCentroDeportivo = centroDeportivoRepository.findById(idCentroDeportivo);
        if (!optCentroDeportivo.isPresent()) {
            throw new NoSuchElementException("No se encuentra el centro deportivo solicitado");
        }
        // Mapearlo a VO y devolverlo
        return modelMapper.map(optCentroDeportivo.get(), CentroDeportivoVO.class);
    }

    public CentroDeportivoVO obtenerCentroUsuario(Long idUsuario) {
        // Leer los datos del usuario
        UsuarioVO usuarioVO = usuarioService.obtenerUsuario(idUsuario);
        Usuario usuario = modelMapper.map(usuarioVO, Usuario.class);
        // Obtener el centro deportivo solicitado
        Optional<CentroDeportivo> optCentroDeportivo = centroDeportivoRepository.findByGestor(usuario);
        if (!optCentroDeportivo.isPresent()) {
            throw new NoSuchElementException("No se encuentra el centro deportivo solicitado");
        }
        // Mapearlo a VO y devolverlo
        return modelMapper.map(optCentroDeportivo.get(), CentroDeportivoVO.class);
    }

    public void actualizarCentro(CentroDeportivoVO centroDeportivoVO) {
        // Mapear a entidad
        CentroDeportivo centroDeportivo = modelMapper.map(centroDeportivoVO, CentroDeportivo.class);
        // Obtener el centro deportivo solicitado
        Optional<CentroDeportivo> optCentroDeportivo = centroDeportivoRepository.findById(centroDeportivo.getIdCentro());
        if (!optCentroDeportivo.isPresent()) {
            throw new NoSuchElementException("No se encuentra el centro deportivo solicitado");
        }
        // Actualizar el usuario
        centroDeportivoRepository.saveAndFlush(centroDeportivo);
    }

    public void borrarCentro(Long idCentroDeportivo) {
        // Obtener el centro deportivo solicitado
        Optional<CentroDeportivo> optCentroDeportivo = centroDeportivoRepository.findById(idCentroDeportivo);
        if (!optCentroDeportivo.isPresent()) {
            throw new NoSuchElementException("No se encuentra el centro deportivo solicitado");
        }
        // Borrar el usuario
        centroDeportivoRepository.deleteById(idCentroDeportivo);
    }
}
