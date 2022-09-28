package com.dh.catalogo.catalogo.rabbit;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CatalogoListener {

//    private final CarroService service;
//
    @RabbitListener(queues = {"${queue.movie.name}"})
    public void receiveMovieMessage(String movieDTO) {
//        service.salvar(carroDTO);
        System.out.println(movieDTO);
    }

    @RabbitListener(queues = {"${queue.serie.name}"})
    public void receiveSerieMessage(String serieDTO) {
//        service.salvar(carroDTO);
        System.out.println(serieDTO);
    }

}
