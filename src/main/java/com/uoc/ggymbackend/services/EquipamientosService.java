package com.uoc.ggymbackend.services;

import com.uoc.ggymbackend.domain.Equipamiento;
import com.uoc.ggymbackend.domain.Reserva;
import com.uoc.ggymbackend.domain.vo.EquipamientoVO;
import com.uoc.ggymbackend.domain.vo.ReservaVO;
import com.uoc.ggymbackend.repositories.EquipamientoRepository;
import com.uoc.ggymbackend.repositories.ReservaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EquipamientosService {

    @Autowired
    private EquipamientoRepository equipamientoRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EquipamientoVO crearEquipamiento(EquipamientoVO equipamientoVO) {
        // Mapear a entidad
        Equipamiento equipamiento = modelMapper.map(equipamientoVO, Equipamiento.class);
        // Guardar en la base de datos
        equipamiento = equipamientoRepository.save(equipamiento);
        // Mapear a VO y devolver
        return modelMapper.map(equipamiento, EquipamientoVO.class);
    }

    public EquipamientoVO obtenerEquipamiento(Long idEquipamiento) {
        // Obtener el equipamiento del centro
        Optional<Equipamiento> optionalEquipamiento = equipamientoRepository.findById(idEquipamiento);
        if (!optionalEquipamiento.isPresent()) {
            throw new NoSuchElementException("No se encuentra el equipamiento solicitado");
        }
        // Mapear a VO y devolverlo
        return modelMapper.map(optionalEquipamiento.get(), EquipamientoVO.class);
    }

    public void actualizarEquipamiento(EquipamientoVO equipamientoVO) {
        // Mapear a entidad
        Equipamiento equipamiento = modelMapper.map(equipamientoVO, Equipamiento.class);
        // Obtener el equipamiento del centro
        Optional<Equipamiento> optionalEquipamiento = equipamientoRepository.findById(equipamientoVO.getIdEquipamiento());
        if (!optionalEquipamiento.isPresent()) {
            throw new NoSuchElementException("No se encuentra el equipamiento solicitado");
        }
        // Actualizar el usuario
        equipamientoRepository.saveAndFlush(equipamiento);
    }

    public void reservarEquipamiento(ReservaVO reservaVO) {
        // Mapear a entidad
        Reserva reserva = modelMapper.map(reservaVO, Reserva.class);
        // Obtener el equipamiento asociado
        EquipamientoVO equipamientoVO = obtenerEquipamiento(reservaVO.getIdEquipamiento());
        Equipamiento equipamiento = modelMapper.map(equipamientoVO, Equipamiento.class);
        reserva.setEquipamiento(equipamiento);
        // Guardar en la base de datos
        reservaRepository.save(reserva);
    }
}
