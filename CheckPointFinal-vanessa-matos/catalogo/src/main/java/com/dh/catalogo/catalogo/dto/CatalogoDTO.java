package com.dh.catalogo.catalogo.dto;

import com.dh.catalogo.catalogo.entity.Catalogo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CatalogoDTO {

    private String genre;
    private List<MovieDTO> movies;
    private List<SerieDTO> series;

    public CatalogoDTO(Catalogo catalogo) {
        this.genre = catalogo.getGenre();

        if (catalogo.getMovies()!=null) {
            this.movies = catalogo.getMovies().stream().map(m -> new MovieDTO(m)).collect(Collectors.toList());
        }

        if (catalogo.getSeries()!=null){
            this.series=catalogo.getSeries().stream().map(s -> new SerieDTO(s)).collect(Collectors.toList());
        }
    }
}
