package com.dh.cadastro.queue;

import com.dh.cadastro.domain.client.PessoaServiceClient;
import com.dh.cadastro.domain.model.Pessoa;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaQueueSender {
    private final PessoaServiceClient serviceClient;
    private final RabbitTemplate template;
    private final Queue queue;

    @Autowired
    public PessoaQueueSender(PessoaServiceClient serviceClient, RabbitTemplate template, Queue queue) {
        this.serviceClient = serviceClient;
        this.template = template;
        this.queue = queue;
    }

    public void send(Pessoa pessoa) {
        final var pessoaArmazenada = serviceClient.createPessoa(pessoa);
        template.convertAndSend(this.queue.getName(), pessoaArmazenada);
    }

}
