package com.uoc.ggymbackend.repositories;

import com.uoc.ggymbackend.domain.CentroDeportivo;
import com.uoc.ggymbackend.domain.Equipamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipamientoRepository extends JpaRepository<Equipamiento, Long> {

    List<Equipamiento> findByCentroDeportivo(CentroDeportivo centroDeportivo);
}
