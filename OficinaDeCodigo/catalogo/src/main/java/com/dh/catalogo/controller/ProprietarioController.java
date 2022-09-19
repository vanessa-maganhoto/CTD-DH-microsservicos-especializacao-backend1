package com.dh.catalogo.controller;

import com.dh.catalogo.dto.CarroDTO;
import com.dh.catalogo.dto.ProprietarioDTO;
import com.dh.catalogo.service.ProprietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProprietarioController {

    @Autowired
    private ProprietarioService service;

    @PostMapping
    private ResponseEntity<ProprietarioDTO> salvar(@RequestBody ProprietarioDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @GetMapping("/nome/{nome}")
    private ResponseEntity<ProprietarioDTO> pesquisarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(service.pesquisarPorNome(nome));
    }

    @GetMapping("/{id}")
    private ResponseEntity<ProprietarioDTO> pesquisarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.pesquisarPorId(id));
    }

    @GetMapping("/carros/{nomeProprietario}")
    private ResponseEntity<List<CarroDTO>> pesquisarCarrosPorProprietario(@PathVariable String nomeProprietario) {
        return ResponseEntity.ok(service.pesquisarCarros(nomeProprietario));
    }

    @GetMapping("/message")
    private ResponseEntity<String> getMessage() {
        return ResponseEntity.ok(service.getMessage());
    }
}
