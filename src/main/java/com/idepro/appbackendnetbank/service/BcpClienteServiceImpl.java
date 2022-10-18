package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.BcpCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.idepro.appbackendnetbank.repository.BcpClienteRepository;


@Service
public class BcpClienteServiceImpl implements BcpClienteService {

    @Autowired
    private BcpClienteRepository bcpClienteRepository;

    @Override
    public BcpCliente findByIdPrestamo(Integer idPrestamo) {
        return bcpClienteRepository.findByIdPrestamo(idPrestamo);
    }
}
