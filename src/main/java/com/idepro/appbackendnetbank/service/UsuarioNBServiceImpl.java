package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.UsuarioNB;
import com.idepro.appbackendnetbank.repository.UsuarioNbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioNBServiceImpl implements UsuarioNBService {
    @Autowired
    private UsuarioNbRepository usuarioNBRepository;

    @Override
    public UsuarioNB obtUsuarioNBPorUsuarioYEstado(String usuario, String estado) {
        return usuarioNBRepository.findUsuarioNbByIdUsuarioByEstado(usuario, estado);
    }

    @Override
    public UsuarioNB findUsuarioNbFirmaActivoByIdUsuario(String usuario) {
        return usuarioNBRepository.findUsuarioNbFirmaActivoByIdUsuario(usuario);
    }
}
