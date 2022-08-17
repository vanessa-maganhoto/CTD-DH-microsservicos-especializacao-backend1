package com.dh.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.RequestPath;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class LoggingGlobalPreFilter implements GlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(LoggingGlobalPreFilter.class);

    private static AtomicInteger COUNT_CALL_GATEWAY = new AtomicInteger(0);

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            GatewayFilterChain chain) {

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            RequestPath path = exchange.getRequest().getPath();
            int count = COUNT_CALL_GATEWAY.incrementAndGet();

            logger.info("Path Requested {}", path);
            logger.info("Numero de chamadas ao gateway {}", count);
            logger.info("Time Response {}", new Date());
        }));
    }
}
