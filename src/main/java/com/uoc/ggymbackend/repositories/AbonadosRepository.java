package com.uoc.ggymbackend.repositories;

import com.uoc.ggymbackend.domain.Abonado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonadosRepository extends JpaRepository<Abonado, Long> {

}
