package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.SudCliente;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 8/6/2022.
 */
public interface SudClienteService {

    SudCliente findClienteByCodigoCliente(String codigoCliente);
    List<SudCliente> listByNumeroDocumento (String numeroDocumento);
}
