package com.dh.logse.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class TestController {

    private static final Logger LOG = Logger.getLogger(TestController.class.getName());

    private static int contador;

    @GetMapping("servico")
    public String servico() {
        LOG.info("Mensagem logada com base no serviço");
        contador += 1;
        return "serviço chamado %d vezes".formatted(contador);
    }

    @GetMapping("exception")
    public void exception() {
        try {
            throw new IllegalAccessException("logstash- exception gerada em /exception");
        }catch (Exception e) {
            LOG.info("Erro ocorrendo em /exception");
        }
    }
}
