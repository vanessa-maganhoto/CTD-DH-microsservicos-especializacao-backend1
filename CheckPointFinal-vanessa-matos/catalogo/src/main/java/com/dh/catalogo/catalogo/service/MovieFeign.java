package com.dh.catalogo.catalogo.service;

import com.dh.catalogo.catalogo.dto.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="MOVIE-SERVICE")
public interface MovieFeign {

    @GetMapping("/movie/{genre}")
    ResponseEntity<List<MovieDTO>> findByGenre(@PathVariable("genre") String genre);
}
//    Atualizar o catálogo utilizando Feign de maneira que adicione a este serviço a
//        busca da serie por género (serie-service) e criar a resposta do endpoint
//        /catalog/{genre}