package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdCliente;
import com.idepro.appbackendnetbank.model.CdGarantia;
import com.idepro.appbackendnetbank.repository.CdFiadorRepository;
import com.idepro.appbackendnetbank.repository.CdGarantiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class CdGarantiaServiceImpl implements CdGarantiaService{
    @Autowired
    private CdGarantiaRepository cdGarantiaRepository;

    @Override
    public List<CdGarantia> listAll() {
        List<CdGarantia> cdGarantiaList = cdGarantiaRepository.listAll();
        if (cdGarantiaList == null) {
            cdGarantiaList = new ArrayList<>();
        }
        return cdGarantiaList;
    }
}
