package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdCreditoAsignado;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 6/4/2022.
 */
public interface CdCreditoAsignadoService {

    List<CdCreditoAsignado> listAll();
    CdCreditoAsignado findByIdCreditoAsignado(String idCreditoAsignado);
}
