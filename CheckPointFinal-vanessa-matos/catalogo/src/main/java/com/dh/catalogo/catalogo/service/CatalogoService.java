package com.dh.catalogo.catalogo.service;

import com.dh.catalogo.catalogo.dto.CatalogoDTO;
import com.dh.catalogo.catalogo.dto.SerieDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogoService {

    @Autowired
    private SerieFeign serieFeign;

    @Value("${queue.serie.name}")
    private String fila;

    private final RabbitTemplate rabbitTemplate;

//    public List<SerieDTO> findByGenre(String genre){
//        CatalogoDTO catalogoDTO =
//    }
}
