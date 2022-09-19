package com.dh.catalogo.service;

import com.dh.catalogo.dto.CarroDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CARROS-SERVICE")
public interface CarroFeign {

    @GetMapping("/carro/proprietario/{idProprietario}")
    ResponseEntity<List<CarroDTO>> pesquisarPorIdProprietario(@PathVariable Long idProprietario);

    @GetMapping("/carro/message")
    ResponseEntity<String> getMessage();
}
