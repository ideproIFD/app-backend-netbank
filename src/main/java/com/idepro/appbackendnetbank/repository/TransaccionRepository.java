package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.Transaccion;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 24/3/2022.
 */
@Repository
@Mapper
public interface TransaccionRepository {

    List<Transaccion> listTransaccionByIdPrestamo(Integer idPrestamo);

    List<Transaccion> listTransaccionCargosByIdPrestamo(Integer idPrestamo);

}
