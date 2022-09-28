package com.dh.catalogo.catalogo.controller;

import com.dh.catalogo.catalogo.dto.CatalogoDTO;
import com.dh.catalogo.catalogo.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class CatalogoController {

    @Autowired
    private CatalogoService catalogoService;

    @GetMapping(value = "/{genre}")
    public ResponseEntity<CatalogoDTO> findByGenre(@PathVariable("genre") String genre) {

        CatalogoDTO dto = catalogoService.findByGenre(genre);
        return ResponseEntity.ok().body(dto);
    }
}
