package com.uoc.ggymbackend.repositories;

import com.uoc.ggymbackend.domain.CuotaAbonado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuotaRepository extends JpaRepository<CuotaAbonado, Long> {

}
