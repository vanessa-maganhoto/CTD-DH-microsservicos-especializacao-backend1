package com.dh.carros.controller;

import com.dh.carros.dto.CarroDTO;
import com.dh.carros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
@RestController
public class CarroController {

    @Autowired
    private CarroService service;

    @PostMapping
    private ResponseEntity<CarroDTO> salvar(@RequestBody CarroDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @GetMapping("/proprietario/{idProprietario}")
    private ResponseEntity<List<CarroDTO>> pesquisarPorProprietario(@PathVariable Long idProprietario) {
        return ResponseEntity.ok(service.pesquisarPorProprietario(idProprietario));
    }

    @GetMapping("/message")
    private ResponseEntity<String> getMessage() {
        return ResponseEntity.ok(service.getMessage());
    }
}
