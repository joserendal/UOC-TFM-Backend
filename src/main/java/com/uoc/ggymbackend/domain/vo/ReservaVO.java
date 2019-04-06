package com.uoc.ggymbackend.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservaVO {

    @Id
    @GeneratedValue
    private Long idReserva;

    @NotNull
    private Long idEquipamiento;

    @NotNull
    private Long idAbonado;

    @NotNull
    private LocalDateTime reservaDesde;

    @NotNull
    private LocalDateTime reservaHasta;
}
