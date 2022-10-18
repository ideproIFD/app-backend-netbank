package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdGestor;
import com.idepro.appbackendnetbank.repository.CdGestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 29/3/2022.
 */
@Service
public class CdGestorServiceImpl implements CdGestorService {
    @Autowired
    private CdGestorRepository cdGestorRepository;

    @Override
    public List<CdGestor> listAll() {
        List<CdGestor> gestorList = cdGestorRepository.listAll();
        if(gestorList == null){
            gestorList = new ArrayList<>();
        }
        return gestorList;
    }

    @Override
    public CdGestor findByIdGestor(Integer idGestor) {
        return cdGestorRepository.findByIdGestor(idGestor);
    }
}
