package com.uoc.ggymbackend.domain;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class PagosAbonado {

    @Id
    @GeneratedValue
    private Long idPagoAbonado;

    @OneToOne
    @JoinColumn(name = "idAbonado")
    private Abonado abonado;

    @NotNull
    @Min(1)
    @Max(12)
    private int mes;

    @NotNull
    @Min(0)
    private Long año;
}