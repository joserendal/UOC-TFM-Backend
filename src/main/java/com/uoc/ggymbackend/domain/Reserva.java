package com.uoc.ggymbackend.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
public class Reserva {

    @Id
    @GeneratedValue
    private Long idReserva;

    private Long idEquipamiento;

    private Long idAbonado;

    private LocalDateTime reservaDesde;

    private LocalDateTime reservaHasta;

    @ManyToOne
    private Equipamiento equipamiento;
}
