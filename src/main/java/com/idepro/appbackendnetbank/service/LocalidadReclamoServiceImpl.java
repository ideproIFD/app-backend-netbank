package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.LocalidadReclamo;
import com.idepro.appbackendnetbank.repository.LocalidadReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 9/11/2021.
 */
@Service
public class LocalidadReclamoServiceImpl implements LocalidadReclamoService {
    @Autowired
    private LocalidadReclamoRepository localidadReclamoRepository;

    @Override
    public List<LocalidadReclamo> listAll() {
        List<LocalidadReclamo> localidadReclamoList = localidadReclamoRepository.listAll();
        if(localidadReclamoList == null){
            localidadReclamoList = new ArrayList<>();
        }
        return localidadReclamoList;
    }
}
