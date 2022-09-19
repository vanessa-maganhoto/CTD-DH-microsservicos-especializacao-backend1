package com.dh.pessoa.domain.service;

import com.dh.pessoa.domain.model.Pessoa;
import com.dh.pessoa.domain.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository repository;

    public PessoaService(PessoaRepository repository) {
        this.repository = repository;
    }

    public List<Pessoa> findByName(String name) {
        return repository.findByName(name);
    }

    public Pessoa create(Pessoa pessoa) {
        return repository.save(pessoa);
    }
}
