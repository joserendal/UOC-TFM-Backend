package com.uoc.ggymbackend.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class PagosAbonado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagoAbonado;

    @OneToOne
    @JoinColumn(name = "idAbonado")
    private Abonado idAbonado;

    @NotNull
    @Min(1)
    @Max(12)
    private int mes;

    @NotNull
    @Min(0)
    private int anio;
}
