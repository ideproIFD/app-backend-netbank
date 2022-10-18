package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.UsuarioNB;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UsuarioNbRepository {
    UsuarioNB findUsuarioNbByIdUsuarioByEstado(String usuario, String estado);

    UsuarioNB findUsuarioNbFirmaActivoByIdUsuario(String usuario);
}
