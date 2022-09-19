package com.dh.catalogo.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class CarroDTO implements Serializable {

    private Long id;
    private String nomeCarro;
    private Long idProprietario;
}
