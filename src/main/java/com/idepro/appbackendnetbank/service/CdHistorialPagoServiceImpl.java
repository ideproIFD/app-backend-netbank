package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdHistorialPago;
import com.idepro.appbackendnetbank.repository.CdHistorialPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 6/4/2022.
 */
@Service
public class CdHistorialPagoServiceImpl implements CdHistorialPagoService {
    @Autowired
    private CdHistorialPagoRepository hisgtorialPagoRepository;

    @Override
    public List<CdHistorialPago> listAll() {
        List<CdHistorialPago> historialPagoList = hisgtorialPagoRepository.listAll();
        if(historialPagoList == null){
            historialPagoList = new ArrayList<>();
        }
        return historialPagoList;
    }

    @Override
    public List<CdHistorialPago> listByFecha(String fecha) {
        List<CdHistorialPago> historialPagoList = hisgtorialPagoRepository.listByFecha(fecha);
        if(historialPagoList == null){
            historialPagoList = new ArrayList<>();
        }
        return historialPagoList;
    }


}
