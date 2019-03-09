package com.uoc.ggymbackend.domain.vo;

import com.uoc.ggymbackend.domain.Abonado;
import com.uoc.ggymbackend.domain.Usuario;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CentroDeportivoVO {

    private Long idCentro;

    private Usuario gestor;

    private String nombreCentro;

    @NotBlank
    private String tipoCentro;

    @NotBlank
    private String direccion;

    @NotBlank
    private String ciudad;

    @NotBlank
    private String provincia;

    @NotBlank
    private String pais;

    @NotBlank
    private String codigoPostal;

    @NotNull
    private boolean privado;

    @NotBlank
    private String numeroTelefono;

    @NotBlank
    private String emailContacto;

    private List<Abonado> abonados;

}