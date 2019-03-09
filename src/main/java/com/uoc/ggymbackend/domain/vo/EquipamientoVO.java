package com.uoc.ggymbackend.domain.vo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EquipamientoVO {

    private Long idEquipamiento;

    @NotBlank
    private String nombreEquipamiento;

    private String descripcionEquipamiento;
}
