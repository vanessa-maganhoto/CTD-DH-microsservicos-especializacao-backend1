package com.dh.catalogo.catalogo.rabbit;

import com.dh.catalogo.catalogo.service.CatalogoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class CatalogoListener {

    @Autowired
    private CatalogoService catalogoService;

    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receiveMovieMessage(String genre) {
        log.info("Novo filme. Genero: {}", genre);
        catalogoService.atualizarMovie(genre);
    }

    @RabbitListener(queues = {"${queue.serie.name}"})
    public void receiveSerieMessage(String genre) {
        log.info("Nova serie. Genero: {}", genre);
        catalogoService.atualizarSerie(genre);
    }

}
