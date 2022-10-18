package com.idepro.appbackendnetbank.repository;

import com.idepro.appbackendnetbank.model.ReporteReclamoDiferido;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 8/12/2021.
 */
@Repository
@Mapper
public interface ReporteReclamoDiferidoRepository {

    List<ReporteReclamoDiferido> listAll();

    List<ReporteReclamoDiferido> listBetweenDate(String fechaInicial, String fechaFinal);
}
