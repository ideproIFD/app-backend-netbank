package com.idepro.appbackendnetbank.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 1/12/2021.
 */
@Repository
@Mapper
public interface ReclamoAdicionalRepository {

    void saveReclamoAdicional(Integer numeroReclamo, String tipoReclamante, Integer numeroTestimonio, String representanteLegal, String fecha, String respuesta, String tipoCredito, String oficialResponsable);
}
