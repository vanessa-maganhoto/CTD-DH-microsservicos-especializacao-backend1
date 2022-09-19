package com.dh.catalogo.service.impl;

import com.dh.catalogo.dto.CarroDTO;
import com.dh.catalogo.dto.ProprietarioDTO;
import com.dh.catalogo.entity.Proprietario;
import com.dh.catalogo.exception.CircuitBreakerException;
import com.dh.catalogo.repository.ProprietarioRepository;
import com.dh.catalogo.service.CarroFeign;
import com.dh.catalogo.service.ProprietarioService;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProprietarioServiceImpl implements ProprietarioService {

    @Value("${message}")
    private String message;

    @Value("${queue.api-carro.name}")
    private String fila;

    @Autowired
    private ProprietarioRepository repository;

    @Autowired
    private CarroFeign carroFeign;

    private final RabbitTemplate rabbitTemplate;

    @Override
    public ProprietarioDTO salvar(ProprietarioDTO dto) {
        Proprietario entity = new Proprietario();
        entity.setNome(dto.getNome());
        Proprietario proprietario = repository.save(entity);
        if (dto.getCarro() != null) {
            dto.getCarro().setIdProprietario(proprietario.getId());
            this.rabbitTemplate.convertAndSend(this.fila, dto.getCarro());
        }
        return entityToDTO(proprietario);
    }

    @Override
    public ProprietarioDTO pesquisarPorId(Long id) {
        Proprietario proprietario = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        return entityToDTO(proprietario);
    }

    @Override
    public ProprietarioDTO pesquisarPorNome(String nome) {
        Proprietario proprietario = repository.findByNome(nome).orElseThrow(EntityNotFoundException::new);
        return entityToDTO(proprietario);
    }

    @Override
    public List<CarroDTO> pesquisarCarros(String nomeProprietario) {
        ProprietarioDTO proprietarioDTO = pesquisarPorNome(nomeProprietario);
        return carroFeign.pesquisarPorIdProprietario(proprietarioDTO.getId()).getBody();
    }

    @Override
    @CircuitBreaker(name="CARROS-SERVICE", fallbackMethod = "metodoException")
    @Retry(name="CARROS-SERVICE")
    public String getMessage() {
        StringBuilder aux = new StringBuilder();
        aux.append(this.message);
        System.out.println("1");
        aux.append(this.carroFeign.getMessage().getBody());
        System.out.println("2");
        return aux.toString();
    }

    public String metodoException(CallNotPermittedException ex) throws CircuitBreakerException {
        StringBuilder aux = new StringBuilder();
        aux.append(this.message);
        aux.append("Carros indisponivel");
        return aux.toString();
    }

    private ProprietarioDTO entityToDTO(Proprietario proprietario) {
        return ProprietarioDTO.builder()
                .id(proprietario.getId())
                .nome(proprietario.getNome())
                .build();
    }
}
