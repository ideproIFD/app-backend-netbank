package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.SudCliente;
import com.idepro.appbackendnetbank.model.SudPrestamo;
import com.idepro.appbackendnetbank.repository.SudClienteRepository;
import com.idepro.appbackendnetbank.repository.SudPrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 8/6/2022.
 */
@Service
public class SudClienteServiceImpl implements SudClienteService {

    @Autowired
    private SudClienteRepository sudClienteRepository;
    @Autowired
    private SudPrestamoRepository sudPrestamoRepository;

    @Override
    public SudCliente findClienteByCodigoCliente(String codigoCliente) {
        SudCliente sudCliente = sudClienteRepository.findByCodigoCliente(codigoCliente);
        if (sudCliente != null) {
            List<SudPrestamo> prestamoList = sudPrestamoRepository.listPrestamoByCodigoCliente(codigoCliente);
            if (prestamoList.size() > 0)
                sudCliente.setPrestamoList(prestamoList);
        }
        return sudCliente;
    }

    @Override
    public List<SudCliente> listByNumeroDocumento(String numeroDocumento) {
        List<SudCliente> clienteList = sudClienteRepository.listByNumeroDocumento(numeroDocumento);
        if (clienteList.size() == 0) {
            clienteList = new ArrayList<>();
        } else {
            for (SudCliente cliente : clienteList) {
                List<SudPrestamo> prestamoList = sudPrestamoRepository.listPrestamoByCodigoCliente(cliente.getCodigoCliente().toString());
                if (prestamoList.size() > 0)
                    cliente.setPrestamoList(prestamoList);
            }

        }
        return clienteList;
    }
}
