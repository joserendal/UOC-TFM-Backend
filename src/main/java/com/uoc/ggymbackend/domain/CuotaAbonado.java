package com.uoc.ggymbackend.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class CuotaAbonado {

    @Id
    @GeneratedValue
    private Long idCuotaAbonado;

    @OneToOne
    @JoinColumn(name = "idAbonado")
    private Abonado abonado;

    @NotNull
    @Min(0)
    private Double importe;

    @NotBlank
    private String periodicidad;

}
