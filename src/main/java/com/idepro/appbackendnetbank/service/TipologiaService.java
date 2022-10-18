package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Tipologia;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 8/11/2021.
 */
public interface TipologiaService {

    List<Tipologia> listAll();

    List<Tipologia> listByIdTipologia(Integer idTipologia);

    Tipologia findByIdTipologiaByIdSubTipologia(Integer idTipologia, Integer idSubTipologia);
}
