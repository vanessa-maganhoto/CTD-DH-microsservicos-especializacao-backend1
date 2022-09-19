package com.dh.cadastro.api.controller;

import com.dh.cadastro.domain.model.Pessoa;
import com.dh.cadastro.queue.PessoaQueueSender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CadastroController {
    private final PessoaQueueSender sender;

    @PostMapping("/pessoas")
    public ResponseEntity<Void> savePessoa(@RequestBody Pessoa pessoa) {
        sender.send(pessoa);
        return ResponseEntity.ok().build();
    }

}
