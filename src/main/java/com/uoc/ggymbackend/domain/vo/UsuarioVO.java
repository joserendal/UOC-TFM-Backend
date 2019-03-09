package com.uoc.ggymbackend.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioVO {

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
