package com.dh.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Configuration
public class FallbackConfiguration {

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions
                .route(RequestPredicates.path("/carro-fallback"),
                        this::handleFallbackCarro)
                .andRoute(RequestPredicates.path("catalogo-fallback"),
                        this::handleFallbackCatalogo);
    }

    private Mono<ServerResponse> handleFallbackCarro(ServerRequest serverRequest) {
        return ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).body(Mono.just("Serviço Carros indisponivel"), String.class);
    }

    private Mono<ServerResponse> handleFallbackCatalogo(ServerRequest serverRequest) {
        return ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).body(Mono.just("Serviço Catalogo indisponivel"), String.class);
    }
}
