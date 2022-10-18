package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdGarantiaAsignado;
import com.idepro.appbackendnetbank.repository.CdGarantiaAsignadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 30/6/2022.
 */
@Service
public class CdGarantiaAsignadoServiceImpl implements CdGarantiaAsignadoService {

    @Autowired
    private CdGarantiaAsignadoRepository cdGarantiaAsignadoRepository;

    @Override
    public List<CdGarantiaAsignado> listAll() {
        List<CdGarantiaAsignado> garantiaAsignadoList = cdGarantiaAsignadoRepository.listAll();
        if(garantiaAsignadoList == null){
            garantiaAsignadoList = new ArrayList<>();
        }
        return garantiaAsignadoList;
    }
}
