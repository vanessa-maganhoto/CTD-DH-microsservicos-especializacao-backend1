package com.checkpoint.catalog.service;

import com.checkpoint.catalog.dto.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="MOVIE-SERVICE")
public interface MovieFeign {

    @GetMapping("/movies/{genre}")
    List<MovieDTO> findByGenre(@PathVariable("genre") String genre);
}
