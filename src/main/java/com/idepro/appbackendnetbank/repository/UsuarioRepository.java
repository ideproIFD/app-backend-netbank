package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.Usuario;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 25/11/2020.
 */
@Repository
@Mapper
public interface UsuarioRepository {

    void saveUsuario(String usuario, String password, String nombre, String descripcion, String email, String estado, String addUser, Integer idRol);

    void updateUsuario(String usuario, String password, String nombre, String descripcion, String email, String estado, String addUser, Integer idRol);

    Usuario findByUsuario(String usuario);

    Usuario findByEmail(String email);

    List<Usuario> listByEstado(String estado);

    List<Usuario> listAll();

}
