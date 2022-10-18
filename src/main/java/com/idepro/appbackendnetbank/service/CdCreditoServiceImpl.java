package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdCredito;
import com.idepro.appbackendnetbank.repository.CdCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 5/4/2022.
 */
@Service
public class CdCreditoServiceImpl implements CdCreditoService {
    @Autowired
    private CdCreditoRepository cdCreditoRepository;

    @Override
    public List<CdCredito> listAll() {
        List<CdCredito> creditoList = cdCreditoRepository.listAll();
        if(creditoList == null){
            creditoList = new ArrayList<>();
        }
        return creditoList;
    }

    @Override
    public CdCredito findByIdCredito(Integer idCredito) {
        return cdCreditoRepository.findByIdCredito(idCredito);
    }
}
