package com.uoc.ggymbackend.repositories;

import com.uoc.ggymbackend.domain.Abonado;
import com.uoc.ggymbackend.domain.CuotaAbonado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CuotaRepository extends JpaRepository<CuotaAbonado, Long> {

    Optional<CuotaAbonado> findByAbonado(Abonado abonado);

}
