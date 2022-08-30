package com.checkpoint.controller;

import com.checkpoint.dto.MovieDTO;
import com.checkpoint.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping
    private ResponseEntity<MovieDTO> save(@RequestBody MovieDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.save(dto));
    }

    @GetMapping("/{genre}")
    private ResponseEntity<List<MovieDTO>> findByGenre(@PathVariable String genre){
        return ResponseEntity.ok(movieService.findByGenre(genre));
    }
}
