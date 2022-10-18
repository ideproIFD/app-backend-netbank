package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.ReporteReclamoDiferido;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 8/12/2021.
 */
public interface ReporteReclamoDiferidoService {
    List<ReporteReclamoDiferido> listAll();

    List<ReporteReclamoDiferido> listEntreFechas(String fechaInicial, String fechaFinal);
}
