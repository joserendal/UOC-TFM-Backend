package com.uoc.ggymbackend.repositories;

import com.uoc.ggymbackend.domain.CentroDeportivo;
import com.uoc.ggymbackend.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CentroDeportivoRepository extends JpaRepository<CentroDeportivo, Long> {

    public Optional<CentroDeportivo> findByGestor(Usuario usuario);

}
