package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.CdAgencia;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 28/3/2022.
 */
@Repository
@Mapper
public interface CdAgenciaRepository {

    CdAgencia findByIdAgencia(Integer idAgencia);
    List<CdAgencia> listAll();
}
