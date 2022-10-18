package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.UsuarioNB;

import java.util.List;

public interface UsuarioNBService {
    UsuarioNB obtUsuarioNBPorUsuarioYEstado(String usuario, String estado);

    UsuarioNB findUsuarioNbFirmaActivoByIdUsuario(String usuario);
}
