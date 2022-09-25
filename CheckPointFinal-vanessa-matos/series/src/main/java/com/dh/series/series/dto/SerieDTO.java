package com.dh.series.series.dto;

import com.dh.series.series.entity.Serie;
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

    public SerieDTO(Serie serie) {
        this.id = serie.getId();
        this.name = serie.getName();
        this.genre = serie.getGenre();
    }
}
