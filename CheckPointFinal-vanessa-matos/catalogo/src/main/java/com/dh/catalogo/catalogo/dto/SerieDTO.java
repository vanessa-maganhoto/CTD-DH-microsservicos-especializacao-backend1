package com.dh.catalogo.catalogo.dto;

import com.dh.catalogo.catalogo.entity.Serie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SerieDTO {

    private Long id;
    private String name;
    private String genre;

    public Serie toEntity(){
        return new Serie(id, name, genre);
    }

    public SerieDTO(Serie serie) {
        this(serie.getId(), serie.getName(), serie.getGenre());
    }
}
