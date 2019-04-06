package com.uoc.ggymbackend.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PagosAbonadoVO {

    private Long idPagoAbonado;

    @NotNull
    private Long idAbonado;

    @NotNull
    @Min(1)
    @Max(12)
    private int mes;

    @NotNull
    @Min(0)
    private int anio;
}
