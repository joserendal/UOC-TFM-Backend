package com.uoc.ggymbackend.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
public class Equipamiento {

    @Id
    @GeneratedValue
    private Long idEquipamiento;

    @NotBlank
    private String nombreEquipamiento;

    private String descripcionEquipamiento;

    @ManyToOne
    private Equipamiento equipamiento;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Reserva> reservas;
}
