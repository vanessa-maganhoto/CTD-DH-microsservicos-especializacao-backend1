package com.dh.catalogo.catalogo.repository;

import com.dh.catalogo.catalogo.entity.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogoRepository extends JpaRepository<Catalogo, String> {
}
