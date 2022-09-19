package com.dh.pessoa.domain.repository;

import com.dh.pessoa.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query("SELECT m FROM Pessoa m WHERE m.name = ?1")
    List<Pessoa> findByName (String name);

}
