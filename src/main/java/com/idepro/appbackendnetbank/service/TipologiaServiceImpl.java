package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Tipologia;
import com.idepro.appbackendnetbank.repository.TipologiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 8/11/2021.
 */
@Service
public class TipologiaServiceImpl implements TipologiaService {

    @Autowired
    private TipologiaRepository tipologiaRepository;


    @Override
    public List<Tipologia> listAll() {
        List<Tipologia> tipologiaList = tipologiaRepository.listAll();
        if(tipologiaList == null) {
            tipologiaList = new ArrayList<>();
        }
        return tipologiaList;
    }

    @Override
    public List<Tipologia> listByIdTipologia(Integer idTipologia) {
        List<Tipologia> tipologiaList = tipologiaRepository.listByIdTipologia(idTipologia);
        if(tipologiaList == null) {
            tipologiaList = new ArrayList<>();
        }
        return tipologiaList;
    }

    @Override
    public Tipologia findByIdTipologiaByIdSubTipologia(Integer idTipologia, Integer idSubTipologia) {
        return tipologiaRepository.findByIdTipologiaByIdSubTipologia(idTipologia, idSubTipologia);
    }
}
