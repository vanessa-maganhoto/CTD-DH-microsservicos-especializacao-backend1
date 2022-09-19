package com.dh.carros.service.impl;

import com.dh.carros.dto.CarroDTO;
import com.dh.carros.entity.Carro;
import com.dh.carros.repository.CarroRepository;
import com.dh.carros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarroServiceImpl implements CarroService {

    @Value("${message}")
    private String message;

    @Autowired
    private CarroRepository repository;

    @Override
    public CarroDTO salvar(CarroDTO dto) {
        Carro entity = new Carro();
        entity.setNomeCarro(dto.getNomeCarro());
        entity.setIdProprietario(dto.getIdProprietario());
        return entityToDTO(repository.save(entity));
    }

    @Override
    public List<CarroDTO> pesquisarPorProprietario(Long idProprietario) {
        return repository.findByIdProprietario(idProprietario)
                .stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public String getMessage() {
        System.out.println("getMessage");
        return this.message;
    }

    private CarroDTO entityToDTO(Carro entity) {
        return CarroDTO.builder().nomeCarro(entity.getNomeCarro()).id(entity.getId()).idProprietario(entity.getIdProprietario()).build();
    }
}
