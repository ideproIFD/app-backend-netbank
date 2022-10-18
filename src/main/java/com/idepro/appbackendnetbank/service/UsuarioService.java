package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Usuario;

import java.util.List;

/**
 * Create by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 25/11/2020.
 */
public interface UsuarioService {

    Usuario save(Usuario usuario);

    Usuario update(Usuario usuario);

    Usuario findByUsuario(String usuario);

    Usuario findByEmail(String email);

    List<Usuario> listByEstado(String estado);

    String saveResetVigente(String email, String usuario);
}
