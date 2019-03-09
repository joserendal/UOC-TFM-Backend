package com.uoc.ggymbackend.domain;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class CentroDeportivo {

    @Id
    @GeneratedValue
    private Long idCentro;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idUsuario")
    private Usuario gestor;

    @NotBlank
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

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Abonado> abonados;

}
