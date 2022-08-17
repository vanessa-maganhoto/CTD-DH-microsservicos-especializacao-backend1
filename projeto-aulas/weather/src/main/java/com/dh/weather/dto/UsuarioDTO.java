package com.dh.weather.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDTO {

    private Long id;
    private String nome;
}
