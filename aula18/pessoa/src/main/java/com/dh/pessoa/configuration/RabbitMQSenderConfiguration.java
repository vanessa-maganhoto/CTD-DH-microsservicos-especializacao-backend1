package com.dh.pessoa.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQSenderConfiguration {

    @Value("${queue.pessoa.name}")
    private String pessoaQueue;

    @Bean
    public Queue queue() {
        return new Queue(pessoaQueue, true);
    }
}
