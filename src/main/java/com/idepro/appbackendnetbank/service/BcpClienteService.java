package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.BcpCliente;

public interface BcpClienteService  {
    BcpCliente findByIdPrestamo(Integer idPrestamo);
}
