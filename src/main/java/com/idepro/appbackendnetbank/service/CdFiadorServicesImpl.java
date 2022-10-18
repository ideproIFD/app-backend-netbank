package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdCliente;
import com.idepro.appbackendnetbank.repository.CdFiadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CdFiadorServicesImpl implements CdFiadorServices {
    @Autowired
    private CdFiadorRepository cdFiadorRepository;

    @Override
    public CdCliente findByIdFiador(Integer idFiador) {
        return cdFiadorRepository.findByIdFiador(idFiador);
    }

    @Override
    public List<CdCliente> listAll() {
        List<CdCliente> cdFiadorList = cdFiadorRepository.listAll();
        if (cdFiadorList == null) {
            cdFiadorList = new ArrayList<>();
        }
        return cdFiadorList;
    }
}
