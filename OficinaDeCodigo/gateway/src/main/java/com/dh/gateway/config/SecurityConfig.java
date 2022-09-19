package com.dh.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.header.XFrameOptionsServerHttpHeadersWriter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain configSecurity(ServerHttpSecurity http,
                                                 ReactiveClientRegistrationRepository reactiveClientRegistrationRepository) {
        http.httpBasic().disable();
        http.oauth2Login();
        http.logout(logout ->
                logout.logoutSuccessHandler(new OidcClientInitiatedServerLogoutSuccessHandler(reactiveClientRegistrationRepository)));
        http.authorizeExchange().anyExchange().authenticated();
        http.headers().frameOptions().mode(XFrameOptionsServerHttpHeadersWriter.Mode.SAMEORIGIN);
        http.csrf().disable();
        return http.build();

    }
}

