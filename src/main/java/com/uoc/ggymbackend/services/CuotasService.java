package com.uoc.ggymbackend.services;

import com.uoc.ggymbackend.domain.Abonado;
import com.uoc.ggymbackend.domain.CuotaAbonado;
import com.uoc.ggymbackend.domain.vo.AbonadoVO;
import com.uoc.ggymbackend.domain.vo.CuotaAbonadoVO;
import com.uoc.ggymbackend.repositories.CuotaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CuotasService {

    @Autowired
    private CuotaRepository cuotaRepository;

    @Autowired
    private AbonadosService abonadosService;

    @Autowired
    private ModelMapper modelMapper;

    public CuotaAbonadoVO crearCuota(CuotaAbonadoVO cuotaAbonadoVO) {
        // Mapear a entidad
        CuotaAbonado cuotaAbonado = modelMapper.map(cuotaAbonadoVO, CuotaAbonado.class);
        // Obtener los datos del abonado
        AbonadoVO abonadoVO = abonadosService.obtenerAbonado(cuotaAbonadoVO.getIdAbonado());
        Abonado abonado = modelMapper.map(abonadoVO, Abonado.class);
        cuotaAbonado.setAbonado(abonado);
        // Guardar en la base de datos
        cuotaAbonado = cuotaRepository.save(cuotaAbonado);
        // Mapear a VO y devolver
        return modelMapper.map(cuotaAbonado, CuotaAbonadoVO.class);
    }

    public CuotaAbonadoVO obtenerCuota(Long idCuota) {
        // Obtener la cuota del abonado
        Optional<CuotaAbonado> optionalCuotaAbonado = cuotaRepository.findById(idCuota);
        if (!optionalCuotaAbonado.isPresent()) {
            throw new NoSuchElementException("No se encuentra la cuota del abonado");
        }
        // Mapear a VO y devolverlo
        return modelMapper.map(optionalCuotaAbonado.get(), CuotaAbonadoVO.class);
    }

    public void actualizarCuota(CuotaAbonadoVO cuotaAbonadoVO) {
        // Mapear a entidad
        CuotaAbonado cuotaAbonado = modelMapper.map(cuotaAbonadoVO, CuotaAbonado.class);
        // Obtener la cuota del abonado
        Optional<CuotaAbonado> optionalCuotaAbonado = cuotaRepository.findById(cuotaAbonadoVO.getIdCuotaAbonado());
        if (!optionalCuotaAbonado.isPresent()) {
            throw new NoSuchElementException("No se encuentra la cuota del abonado");
        }
        // Actualizar el usuario
        cuotaRepository.saveAndFlush(cuotaAbonado);
    }

    public void borrarCuota(Long idCuota) {
        // Obtener la cuota del abonado
        Optional<CuotaAbonado> optionalCuotaAbonado = cuotaRepository.findById(idCuota);
        if (!optionalCuotaAbonado.isPresent()) {
            throw new NoSuchElementException("No se encuentra la cuota del abonado");
        }
        // Borrar el usuario
        cuotaRepository.deleteById(idCuota);
    }
}
