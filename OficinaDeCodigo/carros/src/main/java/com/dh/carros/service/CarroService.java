package com.dh.carros.service;

import com.dh.carros.dto.CarroDTO;

import java.util.List;

public interface CarroService {

    CarroDTO salvar(CarroDTO dto);

    List<CarroDTO> pesquisarPorProprietario(Long idProprietario);

    String getMessage();
}
