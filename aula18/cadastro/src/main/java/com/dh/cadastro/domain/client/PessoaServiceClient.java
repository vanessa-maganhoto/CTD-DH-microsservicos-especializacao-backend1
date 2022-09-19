package com.dh.cadastro.domain.client;

import com.dh.cadastro.domain.model.Pessoa;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "pessoa-service", url = "localhost:8001/pessoa/pessoas")
public interface PessoaServiceClient {

    @GetMapping("{name}")
    ResponseEntity<List<Pessoa>> getPessoasByName(@PathVariable String name);

    @PostMapping("salvar")
    ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa);
}
