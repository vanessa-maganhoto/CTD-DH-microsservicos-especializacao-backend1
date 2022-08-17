package com.dh.usuario.service;

import com.dh.usuario.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @PostMapping
    private ResponseEntity<UsuarioDTO> salvar(@RequestBody UsuarioDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(dto));
    }

    @GetMapping("/{id}")
    private ResponseEntity<UsuarioDTO> pesquisarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.pesquisarPorId(id));
    }
}
