package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.ParametroDiario;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 26/7/2022.
 */
@Repository
@Mapper
public interface ParametroDiarioRepository {

    ParametroDiario listParametroDiario();
}
