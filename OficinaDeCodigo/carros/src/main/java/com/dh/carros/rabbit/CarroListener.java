package com.dh.carros.rabbit;

import com.dh.carros.dto.CarroDTO;
import com.dh.carros.service.CarroService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CarroListener {

    private final CarroService service;

    @RabbitListener(queues = {"${queue.api-carro.name}"})
    public void receiveMessage(CarroDTO carroDTO) {
        service.salvar(carroDTO);
    }

}
