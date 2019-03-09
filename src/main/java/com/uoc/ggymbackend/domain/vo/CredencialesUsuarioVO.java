package com.uoc.ggymbackend.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CredencialesUsuarioVO {

    @NotNull
    private Long idUsuario;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}
