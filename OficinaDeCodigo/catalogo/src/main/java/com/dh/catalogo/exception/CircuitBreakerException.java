package com.dh.catalogo.exception;

public class CircuitBreakerException extends Exception {

    public CircuitBreakerException(String mensagem){
        super(mensagem);
    }

}
