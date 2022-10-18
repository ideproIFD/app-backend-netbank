package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.Clasificador;
import com.idepro.appbackendnetbank.model.RolRecurso;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 14/5/2021.
 */
@Repository
@Mapper
public interface RolRecursoRepository {

    List<RolRecurso> listAll();

    List<RolRecurso> listByIdRol(Integer idRol);

    RolRecurso findByIdRolByIdRecurso(Integer idRol, Integer idRecurso);

    void saveRolRecurso(Integer idRol, Integer idRecurso, String usuario);

    void deleteRolRecursoByIdRol(Integer idRol);
}
