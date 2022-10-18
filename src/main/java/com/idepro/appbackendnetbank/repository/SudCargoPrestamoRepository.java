package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.SudCargoPrestamo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 9/6/2022.
 */
@Repository
@Mapper
public interface SudCargoPrestamoRepository {
    List<SudCargoPrestamo> listCargoByNumeroPrestamo (Integer numeroPrestamo);

    SudCargoPrestamo findCargoByNumeroPrestamoByIdCargo(Integer numeroPrestamo, Integer idCargo);

    void saveCargoPrestamo (Integer numeroPrestamo, Integer idCargo, BigDecimal monto, String usuario);
}
