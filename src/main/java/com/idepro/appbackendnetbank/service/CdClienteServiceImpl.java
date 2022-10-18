package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdCliente;
import com.idepro.appbackendnetbank.repository.CdClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CdClienteServiceImpl implements CdClienteService {

    @Autowired
    private CdClienteRepository cdClienteRepository;

    @Override
    public CdCliente findByIdCliente(Integer idCliente) {
        return cdClienteRepository.findByIdCliente(idCliente);
    }

    @Override
    public List<CdCliente> listAll() {
        List<CdCliente> cdClienteList = cdClienteRepository.listAll();
        if (cdClienteList == null) {
            cdClienteList = new ArrayList<>();
        }
        return cdClienteList;
    }
}
