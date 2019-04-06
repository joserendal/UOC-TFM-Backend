package com.uoc.ggymbackend.repositories;

import com.uoc.ggymbackend.domain.Equipamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipamientoRepository extends JpaRepository<Equipamiento, Long> {
}
