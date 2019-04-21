package com.uoc.ggymbackend.services;

import com.uoc.ggymbackend.domain.Abonado;
import com.uoc.ggymbackend.domain.CentroDeportivo;
import com.uoc.ggymbackend.domain.vo.AbonadoVO;
import com.uoc.ggymbackend.domain.vo.CentroDeportivoVO;
import com.uoc.ggymbackend.repositories.AbonadosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AbonadosService {

    @Autowired
    private AbonadosRepository abonadosRepository;

    @Autowired
    private CentrosService centrosService;

    @Autowired
    private ModelMapper modelMapper;

    public AbonadoVO crearAbonado(AbonadoVO abonadoVO) {
        // Mapear a entidad
        Abonado abonado = modelMapper.map(abonadoVO, Abonado.class);
        // Obtener los datos del centro deportivo
        CentroDeportivoVO centroVO = centrosService.obtenerCentro(abonadoVO.getIdCentroDeportivo());
        CentroDeportivo centro = modelMapper.map(centroVO, CentroDeportivo.class);
        abonado.setCentroDeportivo(centro);
        // Guardar en la base de datos
        abonado = abonadosRepository.save(abonado);
        // Mapear a VO y devolver
        return modelMapper.map(abonado, AbonadoVO.class);
    }

    public AbonadoVO obtenerAbonado(Long idAbonado) {
        // Obtener el abonado solicitado
        Optional<Abonado> optUsuario = abonadosRepository.findById(idAbonado);
        if (!optUsuario.isPresent()) {
            throw new NoSuchElementException("No se encuentra el abonado solicitado");
        }
        // Mapear el usuario a VO y devolverlo
        return modelMapper.map(optUsuario.get(), AbonadoVO.class);
    }

    public void actualizarAbonado(AbonadoVO abonadoVO) {
        // Mapear a entidad
        Abonado abonado = modelMapper.map(abonadoVO, Abonado.class);
        // Obtener el abonado solicitado
        Optional<Abonado> optUsuario = abonadosRepository.findById(abonado.getIdAbonado());
        if (!optUsuario.isPresent()) {
            throw new NoSuchElementException("No se encuentra el abonado solicitado");
        }
        // Actualizar el usuario
        abonadosRepository.saveAndFlush(abonado);
    }

    public void borrarAbonado(Long idAbonado) {
        // Obtener el abonado solicitado
        Optional<Abonado> optUsuario = abonadosRepository.findById(idAbonado);
        if (!optUsuario.isPresent()) {
            throw new NoSuchElementException("No se encuentra el abonado solicitado");
        }
        // Borrar el usuario
        abonadosRepository.deleteById(idAbonado);
    }

    public List<AbonadoVO> obtenerListadoAbonados(Long idCentroDeportivo) {
        // Obtener los datos del centro deportivo
        CentroDeportivoVO centro = centrosService.obtenerCentro(idCentroDeportivo);
        // Devolver el listado de abonados del centro
        List<AbonadoVO> abonados = centro.getAbonados();
        // Ordenar alfabéticamente
        Collections.sort(abonados);
        return abonados;
    }
}
