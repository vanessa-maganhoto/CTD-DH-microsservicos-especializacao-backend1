package com.dh.usuario.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
public class UsuarioDTO {

    private Long id;
    private String nome;
}
