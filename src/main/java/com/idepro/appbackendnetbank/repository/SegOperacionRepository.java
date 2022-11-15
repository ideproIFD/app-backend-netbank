package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.SegMiVida;
import com.idepro.appbackendnetbank.model.SoliPago;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SegOperacionRepository {
    List<SegMiVida> findPorFechas(String fechaInicial, String fechaFinal);
}
