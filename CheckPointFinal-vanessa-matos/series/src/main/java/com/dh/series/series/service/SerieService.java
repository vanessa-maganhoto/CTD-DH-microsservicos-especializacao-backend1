package com.dh.series.series.service;

import com.dh.series.series.dto.SerieDTO;
import com.dh.series.series.entity.Serie;
import com.dh.series.series.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    @Transactional
    public SerieDTO insert(SerieDTO dto){
        Serie serie = new Serie();
        serie.setName(dto.getName());
        serie.setGenre(dto.getGenre());
        return new SerieDTO(serie);
    }

    @Transactional(readOnly = true)
    public List<SerieDTO> findAll (String genre){
        List<Serie> serieList = serieRepository.findByGenero(genre);
        return serieList.stream().map(x -> new SerieDTO(x)).collect(Collectors.toList());
    }
}
