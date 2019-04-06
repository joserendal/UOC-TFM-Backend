package com.uoc.ggymbackend.domain.vo;

import com.uoc.ggymbackend.domain.Reserva;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EquipamientoVO {

    private Long idEquipamiento;

    @NotBlank
    private String nombreEquipamiento;

    private String descripcionEquipamiento;

    private List<Reserva> reservas;
}
