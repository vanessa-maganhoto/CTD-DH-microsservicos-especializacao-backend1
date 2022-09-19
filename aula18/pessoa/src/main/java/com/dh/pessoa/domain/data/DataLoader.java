package com.dh.pessoa.domain.data;

import com.dh.pessoa.domain.model.Pessoa;
import com.dh.pessoa.domain.repository.PessoaRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private PessoaRepository repository;

    public DataLoader (PessoaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run (ApplicationArguments args) throws Exception {
        repository.save(new Pessoa(1L, "fabricio", "masculino", "dh"));
        repository.save(new Pessoa(2L, "fabio", "masculino", "dh"));
        repository.save(new Pessoa(3L, "fabiana", "feminino", "dh"));
    }
}

