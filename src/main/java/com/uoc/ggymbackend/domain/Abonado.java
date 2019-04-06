package com.uoc.ggymbackend.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
public class Abonado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbonado;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellidos;

    private String direccion;

    private String ciudad;

    private String provincia;

    private String pais;

    private String codigoPostal;

    private String email;

    @NotBlank
    private String numeroTelefono;

    private String rutaImagen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_centro")
    private CentroDeportivo centroDeportivo;

    @OneToMany(mappedBy = "abonado", cascade = CascadeType.ALL)
    private List<Reserva> reservas;

}
