package com.uoc.ggymbackend.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReserva;

    private LocalDateTime reservaDesde;

    private LocalDateTime reservaHasta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_abonado")
    private Abonado abonado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipamiento")
    private Equipamiento equipamiento;
}
