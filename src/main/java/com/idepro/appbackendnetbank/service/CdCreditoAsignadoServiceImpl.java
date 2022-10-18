package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdCreditoAsignado;
import com.idepro.appbackendnetbank.repository.CdCreditoAsignadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 6/4/2022.
 */
@Service
public class CdCreditoAsignadoServiceImpl implements CdCreditoAsignadoService {
    @Autowired
    private CdCreditoAsignadoRepository creditoAsignadoRepository;

    @Override
    public List<CdCreditoAsignado> listAll() {
        List<CdCreditoAsignado> creditoAsignadoList = creditoAsignadoRepository.listAll();
        if(creditoAsignadoList == null){
            creditoAsignadoList = new ArrayList<>();
        }
        return creditoAsignadoList;
    }

    @Override
    public CdCreditoAsignado findByIdCreditoAsignado(String idCreditoAsignado) {
        return creditoAsignadoRepository.findByIdCreditoAsignado(idCreditoAsignado);
    }
}
