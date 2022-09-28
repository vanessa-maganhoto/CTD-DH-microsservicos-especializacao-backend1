package com.dh.movie.movie.service;

import com.dh.movie.movie.config.RabbitMQSenderConfig;
import com.dh.movie.movie.dto.MovieDTO;
import com.dh.movie.movie.entities.Movie;
import com.dh.movie.movie.repository.MovieRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMQSenderConfig rabbitMQSenderConfig;

    @Transactional
    public MovieDTO insert(MovieDTO dto) {

        Movie movie = new Movie();
        movie.setId(dto.getId());
        movie.setName(dto.getName());
        movie.setGenre(dto.getGenre());
        movie.setUrlStream(dto.getUrlStream());

        movie = movieRepository.save(movie);

        rabbitTemplate.convertAndSend(rabbitMQSenderConfig.getMovieQueue(), movie.getGenre());
        return new MovieDTO(movie);
    }

    @Transactional(readOnly = true)
    public List<MovieDTO> findAll(String genre) {
        List<Movie> movieList = movieRepository.findByGenre(genre);
        return movieList.stream().map(x -> new MovieDTO(x)).collect(Collectors.toList());
    }
}
