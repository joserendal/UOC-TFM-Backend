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
public class AbonadoVO {

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