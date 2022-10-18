package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.SudPlanPago;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 23/5/2022.
 */
@Repository
@Mapper
public interface SudPlanPagoRepository {
    List<SudPlanPago> listPlanPagoByNumeroPrestamo(Integer numeroPrestamo);
}
