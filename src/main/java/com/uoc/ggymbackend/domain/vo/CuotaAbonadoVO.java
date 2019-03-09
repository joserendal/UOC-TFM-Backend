package com.uoc.ggymbackend.domain.vo;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CuotaAbonadoVO {

    private Long idCuotaAbonado;

    private AbonadoVO abonado;

    @NotNull
    @Min(0)
    private Double importe;

    @NotBlank
    private String periodicidad;

}
