package com.dh.catalogo.catalogo.service;

import com.dh.catalogo.catalogo.dto.CatalogoDTO;
import com.dh.catalogo.catalogo.dto.MovieDTO;
import com.dh.catalogo.catalogo.dto.SerieDTO;
import com.dh.catalogo.catalogo.entity.Catalogo;
import com.dh.catalogo.catalogo.entity.Movie;
import com.dh.catalogo.catalogo.entity.Serie;
import com.dh.catalogo.catalogo.repository.CatalogoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CatalogoService {

    @Autowired
    private SerieFeign serieFeign;

    @Autowired
    private MovieFeign movieFeign;

    @Autowired
    private CatalogoRepository catalogoRepository ;

public void atualizarMovie(String genre){
    ResponseEntity<List<MovieDTO>> movieResponse = movieFeign.findByGenre(genre);
    if (movieResponse.getBody() != null) {
        List<MovieDTO> dtos = movieResponse.getBody();
        Set<Movie> movies = dtos.stream().map(MovieDTO::toEntity).collect(Collectors.toSet());

        Catalogo catalogo = catalogoRepository.findById(genre).orElse(new Catalogo(genre));
        catalogo.setMovies(movies);

        catalogoRepository.save(catalogo);
    }
}

public void atualizarSerie(String genre){
    ResponseEntity<List<SerieDTO>> serieResponse = serieFeign.findByGenre(genre);
    if (serieResponse.getBody() != null) {
        List<SerieDTO> dtos = serieResponse.getBody();
        Set<Serie> series = dtos.stream().map(SerieDTO::toEntity).collect(Collectors.toSet());

        Catalogo catalogo = catalogoRepository.findById(genre).orElse(new Catalogo(genre));
        catalogo.setSeries(series);

        catalogoRepository.save(catalogo);
    }
}

public CatalogoDTO findByGenre(String genre) {
    Catalogo catalogo = catalogoRepository.findById(genre).orElse(new Catalogo(genre));

    return new CatalogoDTO(catalogo);
}
}
