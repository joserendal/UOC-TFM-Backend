package com.uoc.ggymbackend.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EquipamientoVO implements Comparable {

    private Long idEquipamiento;

    @NotNull
    private Long idCentroDeportivo;

    @NotBlank
    private String nombreEquipamiento;

    private String descripcionEquipamiento;

    private List<ReservaVO> reservas;

    @Override
    public int compareTo(Object o) {
        return this.getNombreEquipamiento().compareToIgnoreCase(((EquipamientoVO) o).getNombreEquipamiento());
    }
}
