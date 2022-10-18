package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdLineaCredito;
import com.idepro.appbackendnetbank.repository.CdLineaCreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 6/4/2022.
 */
@Service
public class CdLineaCreditoServiceImpl implements CdLineaCreditoService {
    @Autowired
    private CdLineaCreditoRepository lineaCreditoRepository;

    @Override
    public List<CdLineaCredito> listAll() {
        List<CdLineaCredito> lineaCreditoList = lineaCreditoRepository.listAll();
        if(lineaCreditoList == null){
            lineaCreditoList = new ArrayList<>();
        }
        return lineaCreditoList;
    }

    @Override
    public CdLineaCredito findByIdLineaCredito(Integer idLineaCredito) {
        return lineaCreditoRepository.findByIdLineaCredito(idLineaCredito);
    }
}
