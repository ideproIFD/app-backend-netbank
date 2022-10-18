package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdLineaCredito;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 6/4/2022.
 */
public interface CdLineaCreditoService {
    List<CdLineaCredito> listAll();
    CdLineaCredito findByIdLineaCredito(Integer idLineaCredito);
}
