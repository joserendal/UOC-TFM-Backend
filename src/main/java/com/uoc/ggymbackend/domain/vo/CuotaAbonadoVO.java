package com.uoc.ggymbackend.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CuotaAbonadoVO {

    private Long idCuotaAbonado;

    @NotNull
    private Long idAbonado;

    @NotNull
    @Min(0)
    private Double importe;

    @NotBlank
    private String periodicidad;

}
