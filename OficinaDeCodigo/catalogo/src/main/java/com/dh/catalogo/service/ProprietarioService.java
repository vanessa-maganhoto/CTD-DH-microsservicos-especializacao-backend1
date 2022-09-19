package com.dh.catalogo.service;

import com.dh.catalogo.dto.CarroDTO;
import com.dh.catalogo.dto.ProprietarioDTO;

import java.util.List;

public interface ProprietarioService {

    ProprietarioDTO salvar(ProprietarioDTO dto);

    ProprietarioDTO pesquisarPorId(Long id);

    ProprietarioDTO pesquisarPorNome(String nome);

    List<CarroDTO> pesquisarCarros(String nomeProprietario);

    String getMessage();
}
