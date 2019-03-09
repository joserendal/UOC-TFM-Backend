package com.uoc.ggymbackend.domain.vo;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PagosAbonadoVO {

    private Long idPagoAbonado;

    private AbonadoVO abonado;

    @NotNull
    @Min(1)
    @Max(12)
    private int mes;

    @NotNull
    @Min(0)
    private Long año;
}
