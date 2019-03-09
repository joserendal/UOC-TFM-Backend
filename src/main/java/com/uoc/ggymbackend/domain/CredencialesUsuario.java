package com.uoc.ggymbackend.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
public class CredencialesUsuario implements Serializable {

    @Id
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
}
