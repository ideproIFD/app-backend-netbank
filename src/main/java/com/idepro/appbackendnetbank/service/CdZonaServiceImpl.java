package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdZona;
import com.idepro.appbackendnetbank.repository.CdZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 29/3/2022.
 */
@Service
public class CdZonaServiceImpl implements CdZonaService {

    @Autowired
    private CdZonaRepository cdZonaRepository;

    @Override
    public List<CdZona> listAll() {
        List<CdZona> zonaList = cdZonaRepository.listAll();
        if(zonaList == null){
            zonaList = new ArrayList<>();
        }
        return zonaList;
    }

    @Override
    public CdZona findByIdZona(Integer idZona) {
        return cdZonaRepository.findByIdZona(idZona);
    }
}
