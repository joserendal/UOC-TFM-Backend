package com.uoc.ggymbackend.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Abonado {

    @Id
    @GeneratedValue
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

}
