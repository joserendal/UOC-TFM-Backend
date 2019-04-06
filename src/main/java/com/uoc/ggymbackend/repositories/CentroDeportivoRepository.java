package com.uoc.ggymbackend.repositories;

import com.uoc.ggymbackend.domain.CentroDeportivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CentroDeportivoRepository extends JpaRepository<CentroDeportivo, Long> {

}
