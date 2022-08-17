package com.dh.weather.service;

import com.dh.weather.config.LoadBalancerConfiguration;
import com.dh.weather.dto.UsuarioDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="USUARIO-SERVICE")
@LoadBalancerClient(name = "USUARIO-SERVICE", configuration = LoadBalancerConfiguration.class)
public interface UsuarioFeign {

    @GetMapping("/usuario/{id}")
    ResponseEntity<UsuarioDTO> pesquisarPorId(@PathVariable Long id);
}
