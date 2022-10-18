package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdCredito;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 5/4/2022.
 */
public interface CdCreditoService {

    List<CdCredito> listAll();
    CdCredito findByIdCredito(Integer idCredito);
}
