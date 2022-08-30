package com.checkpoint.catalog.controller;

import com.checkpoint.catalog.dto.MovieDTO;
import com.checkpoint.catalog.service.MovieFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CatalogGenreController {


    @Autowired
    private  MovieFeign movieFeign;

    @GetMapping("/{genre}")
    private List<MovieDTO> findByGenre(@PathVariable String genre){
        return movieFeign.findByGenre(genre);
    }

}
