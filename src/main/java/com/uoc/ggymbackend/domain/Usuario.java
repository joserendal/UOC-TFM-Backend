package com.uoc.ggymbackend.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellidos;

    @NotNull
    private LocalDate fechaNacimiento;

    private int codigoPostal;

    private String ciudad;

    private String provincia;

    @NotBlank
    private String pais;
}
