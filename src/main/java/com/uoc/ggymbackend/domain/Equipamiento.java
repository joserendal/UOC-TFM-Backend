package com.uoc.ggymbackend.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
public class Equipamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipamiento;

    @NotBlank
    private String nombreEquipamiento;

    private String descripcionEquipamiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_centro")
    private CentroDeportivo centroDeportivo;

    @OneToMany(mappedBy = "equipamiento", cascade = CascadeType.ALL)
    private List<Reserva> reservas;
}
