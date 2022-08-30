package com.checkpoint.service.impl;

import com.checkpoint.dto.MovieDTO;
import com.checkpoint.entity.Movie;
import com.checkpoint.repository.MovieRepository;
import com.checkpoint.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;


    private MovieDTO entityToDto(Movie movie){
        return MovieDTO.builder().name(movie.getName()).id(movie.getId()).genre(movie.getGenre()).urlStream(movie.getUrlStream()).build();
    }

    @Override
    public MovieDTO save(MovieDTO dto) {
        Movie newMovie = new Movie();
        newMovie.setName(dto.getName());
        newMovie.setGenre(dto.getGenre());
        newMovie.setUrlStream(dto.getUrlStream());
        return entityToDto(movieRepository.save(newMovie));
    }

    @Override
    public List<MovieDTO> findByGenre(String genre) {
        return movieRepository.findByGenre(genre)
                .stream().map(this::entityToDto)
                .collect(Collectors.toList());
    }
}
