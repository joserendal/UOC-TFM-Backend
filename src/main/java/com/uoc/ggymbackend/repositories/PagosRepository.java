package com.uoc.ggymbackend.repositories;

import com.uoc.ggymbackend.domain.Abonado;
import com.uoc.ggymbackend.domain.PagosAbonado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagosRepository extends JpaRepository<PagosAbonado, Long> {


    PagosAbonado findByIdAbonadoAndMesAndAnio(Abonado idAbonado, int mes, int anio);

}
