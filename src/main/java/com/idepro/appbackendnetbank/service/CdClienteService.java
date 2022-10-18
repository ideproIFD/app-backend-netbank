package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdCliente;

import java.util.List;

public interface CdClienteService {

    CdCliente findByIdCliente(Integer idCiente);
    List<CdCliente> listAll();
}
