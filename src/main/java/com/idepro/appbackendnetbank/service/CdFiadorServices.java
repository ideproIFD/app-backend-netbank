package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdCliente;

import java.util.List;

public interface CdFiadorServices {
    CdCliente findByIdFiador(Integer idFiador);

    List<CdCliente> listAll();
}
