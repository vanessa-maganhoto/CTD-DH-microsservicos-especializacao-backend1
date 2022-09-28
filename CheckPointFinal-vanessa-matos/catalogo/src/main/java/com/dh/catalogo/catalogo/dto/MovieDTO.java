package com.dh.catalogo.catalogo.dto;

import com.dh.catalogo.catalogo.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Long id;
    private String name;
    private String genre;
    private String urlStream;

    public Movie toEntity() {
        return new Movie(id, name, genre, urlStream);
    }

    public MovieDTO(Movie movie) {
        this(movie.getId(), movie.getName(), movie.getGenre(), movie.getUrlStream());
    }
}
