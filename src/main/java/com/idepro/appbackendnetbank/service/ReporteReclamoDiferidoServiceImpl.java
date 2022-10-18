package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.ReporteReclamoDiferido;
import com.idepro.appbackendnetbank.repository.ReporteReclamoDiferidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 8/12/2021.
 */
@Service
public class ReporteReclamoDiferidoServiceImpl implements ReporteReclamoDiferidoService {

    @Autowired
    private ReporteReclamoDiferidoRepository reporteReclamoDiferidoRepository;

    @Override
    public List<ReporteReclamoDiferido> listAll() {
        List<ReporteReclamoDiferido> reporteReclamoDiferidoList = reporteReclamoDiferidoRepository.listAll();
        if (reporteReclamoDiferidoList == null) {
            reporteReclamoDiferidoList = new ArrayList<>();
        }
        return reporteReclamoDiferidoList;
    }

    @Override
    public List<ReporteReclamoDiferido> listEntreFechas(String fechaInicial, String fechaFinal) {
        List<ReporteReclamoDiferido> reporteReclamoDiferidoList = reporteReclamoDiferidoRepository.listBetweenDate(fechaInicial, fechaFinal);
        if (reporteReclamoDiferidoList == null) {
            reporteReclamoDiferidoList = new ArrayList<>();
        }
        return reporteReclamoDiferidoList;
    }
}
