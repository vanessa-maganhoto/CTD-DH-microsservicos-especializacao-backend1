package com.dh.series.series.repository;

import com.dh.series.series.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Long> {
    List<Serie> findByGenre(String genre);
}
