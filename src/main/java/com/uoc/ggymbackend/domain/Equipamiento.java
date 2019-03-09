package com.uoc.ggymbackend.domain;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Equipamiento {

    @Id
    @GeneratedValue
    private Long idEquipamiento;

    @NotBlank
    private String nombreEquipamiento;

    private String descripcionEquipamiento;
}
