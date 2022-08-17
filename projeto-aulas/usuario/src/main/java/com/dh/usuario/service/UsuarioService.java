package com.dh.usuario.service;

import com.dh.usuario.dto.UsuarioDTO;

public interface UsuarioService {
    UsuarioDTO salvar(UsuarioDTO dto);

    UsuarioDTO pesquisarPorId(Long id);
}
