package com.dh.pessoa.api.controller;

import com.dh.pessoa.domain.model.Pessoa;
import com.dh.pessoa.domain.service.PessoaService;
import com.dh.pessoa.queue.PessoaListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    private final PessoaService service;
    private final PessoaListener listener;

    @Autowired
    public PessoaController(PessoaService service, PessoaListener listener) {
        this.service = service;
        this.listener = listener;
    }

    @GetMapping("{name}")
    ResponseEntity<List<Pessoa>> getPessoasByName(@PathVariable String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @PostMapping
    ResponseEntity<Void> createPessoa(@RequestBody Pessoa pessoa) {
        listener.receive(pessoa);
        return ResponseEntity.ok().build();
    }
}
