package com.dh.catalogo.catalogo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CatalogoDTO {

    private MovieDTO movieDTO;
    private SerieDTO serieDTO;
}
