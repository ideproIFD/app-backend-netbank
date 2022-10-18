package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdGestor;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 29/3/2022.
 */
public interface CdGestorService {
    List<CdGestor> listAll();
    CdGestor findByIdGestor(Integer idGestor);
}
