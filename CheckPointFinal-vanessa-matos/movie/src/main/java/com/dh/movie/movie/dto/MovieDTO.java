package com.dh.movie.movie.dto;

import com.dh.movie.movie.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MovieDTO {

    private Long id;
    private String name;
    private String genre;
    private String urlStream;

    public MovieDTO() {
    }

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.name = movie.getName();
        this.genre = movie.getGenre();
        this.urlStream = movie.getUrlStream();
    }
}
