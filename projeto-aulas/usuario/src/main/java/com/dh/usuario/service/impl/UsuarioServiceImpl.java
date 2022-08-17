package com.dh.usuario.service.impl;

import com.dh.usuario.dto.UsuarioDTO;
import com.dh.usuario.entity.Usuario;
import com.dh.usuario.repository.UsuarioRepository;
import com.dh.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Value("${server.port}")
    private String porta;

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UsuarioDTO salvar(UsuarioDTO dto) {
        var usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNome(dto.getNome());
        usuario = repository.save(usuario);
        return getDto(usuario);
    }

    @Override
    public UsuarioDTO pesquisarPorId(Long id) {
        var user = repository.findById(id).orElseThrow(EntityNotFoundException::new);
        user.setNome(user.getNome() + "Porta: " + porta);
        return getDto(user);
    }

    private UsuarioDTO getDto(Usuario user) {
        return UsuarioDTO.builder()
                .id(user.getId())
                .nome(user.getNome())
                .build();
    }
}
