package com.uoc.ggymbackend.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AbonadoVO implements Comparable {

    private Long idAbonado;

    private Long idCentroDeportivo;

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellidos;

    @NotNull
    private LocalDate fechaNacimiento;

    private String direccion;

    private String ciudad;

    private String provincia;

    private String pais;

    private String codigoPostal;

    private String email;

    @NotBlank
    private String numeroTelefono;

    private String rutaImagen;

    @Override
    public int compareTo(Object o) {
        return this.getApellidos().compareToIgnoreCase(((AbonadoVO) o).getApellidos());
    }
}