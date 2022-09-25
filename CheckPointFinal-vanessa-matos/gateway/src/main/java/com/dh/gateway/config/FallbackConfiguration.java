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
                .route(RequestPredicates.path("/serie-fallback"),
                        this::handleFallbackSerie)
                .andRoute(RequestPredicates.path("/movie-fallback"),
                        this::handleFallbackCatalogo)
                .andRoute(RequestPredicates.path("/catalogo-fallback"),
                        this::handleFallbackCatalogo);
    }

    private Mono<ServerResponse> handleFallbackSerie(ServerRequest serverRequest) {
        return ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).body(Mono.just("Serviço Serie indisponivel"), String.class);
    }

    private Mono<ServerResponse> handleFallbackMovie(ServerRequest serverRequest) {
        return ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).body(Mono.just("Serviço Movie indisponivel"), String.class);
    }

    private Mono<ServerResponse> handleFallbackCatalogo(ServerRequest serverRequest) {
        return ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).body(Mono.just("Serviço Catalogo indisponivel"), String.class);
    }
}
