package com.dh.pessoa.queue;

import com.dh.pessoa.domain.model.Pessoa;
import com.dh.pessoa.domain.service.PessoaService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PessoaListener {

    private final PessoaService service;

    public PessoaListener(PessoaService service) {
        this.service = service;
    }

    @RabbitListener(queues = {"${queue.pessoa.name}"})
    public void receive(@Payload Pessoa pessoa) {
        service.create(pessoa);
    }
}
