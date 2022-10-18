package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdCliente;
import com.idepro.appbackendnetbank.model.CdFiadorAsignado;
import com.idepro.appbackendnetbank.repository.CdFiadorAsignadoRepository;
import com.idepro.appbackendnetbank.repository.CdFiadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CdFiadorAsignadoServiceImpl implements CdFiadorAsignadoService {

    @Autowired
    private CdFiadorAsignadoRepository cdFiadorAsignadoRepository;

    @Override
    public List<CdFiadorAsignado> listAll() {
        List<CdFiadorAsignado> cdFiadorAsignadoList = cdFiadorAsignadoRepository.listAll();
        if (cdFiadorAsignadoList == null) {
            cdFiadorAsignadoList = new ArrayList<>();
        }
        return cdFiadorAsignadoList;
    }
}
