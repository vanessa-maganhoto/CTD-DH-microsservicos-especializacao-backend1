package com.dh.catalogo.dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
public class ProprietarioDTO implements Serializable {

    private Long id;
    private String nome;
    private CarroDTO carro;

}
