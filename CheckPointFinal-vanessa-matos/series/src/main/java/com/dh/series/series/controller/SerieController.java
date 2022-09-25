package com.dh.series.series.controller;

import com.dh.series.series.dto.SerieDTO;
import com.dh.series.series.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping(value = "/{genre}")
    public ResponseEntity<List<SerieDTO>> findByGenre (String genre){
        List<SerieDTO> list = serieService.findAll(genre);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<SerieDTO> insert (@RequestBody SerieDTO serieDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(serieService.insert(serieDTO));
    }
}
