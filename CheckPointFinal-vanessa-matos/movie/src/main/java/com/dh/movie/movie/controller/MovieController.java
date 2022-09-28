package com.dh.movie.movie.controller;

import com.dh.movie.movie.dto.MovieDTO;
import com.dh.movie.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/{genre}")
    public ResponseEntity<List<MovieDTO>> findByGenre (@PathVariable("genre") String genre){
        List<MovieDTO> list = movieService.findAll(genre);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<MovieDTO> insert (@RequestBody MovieDTO movieDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.insert(movieDTO));
    }
}
