package com.dh.gateway.controller;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @CircuitBreaker(name= "carroService" /*, fallbackMethod = "metodoException"*/)
    @GetMapping("/carro")
    ResponseEntity<String> carroFallback(){
//        throw new CallNotPermittedException("");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Serviço de carro indisponível");
    }

//    public ResponseEntity<String> metodoException(CallNotPermittedException ex)  {
//
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Serviço de carro indisponível");
//    }

}
