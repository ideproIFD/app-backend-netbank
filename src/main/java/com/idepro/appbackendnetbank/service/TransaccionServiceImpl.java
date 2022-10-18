package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Transaccion;
import com.idepro.appbackendnetbank.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 24/3/2022.
 */
@Service
public class TransaccionServiceImpl implements TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Override
    public List<Transaccion> listTransaccionByIdPrestamo(Integer idPrestamo) {
        List<Transaccion> transaccionList = new ArrayList<>();
        if(idPrestamo != null){
            transaccionList = transaccionRepository.listTransaccionByIdPrestamo(idPrestamo);
        }
        return transaccionList;
    }

    @Override
    public List<Transaccion> listTransaccionCargosByIdPrestamo(Integer idPrestamo) {
        List<Transaccion> transaccionList = new ArrayList<>();
        if(idPrestamo != null){
            transaccionList = transaccionRepository.listTransaccionCargosByIdPrestamo(idPrestamo);
        }
        return transaccionList;
    }
}
