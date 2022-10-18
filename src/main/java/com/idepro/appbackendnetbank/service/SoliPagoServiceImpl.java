package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.SoliPago;
import com.idepro.appbackendnetbank.repository.SoliPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 3/5/2022.
 */
@Service
public class SoliPagoServiceImpl implements SoliPagoService {
    @Autowired
    private SoliPagoRepository soliPagoRepository;

    @Override
    public List<SoliPago> listAll() {
        List<SoliPago> soliPagoList = soliPagoRepository.listAll();
        if (soliPagoList.size() == 0) {
            soliPagoList = new ArrayList<>();
        } else {
            List<SoliPago> soliPagoListNuevo = new ArrayList<>();
            for (SoliPago soliPago : soliPagoList) {
                //int numero = (int)(Math.random()*10+1);
                soliPago.setMonto(new BigDecimal(Math.random()*456.2).round(new MathContext(5)));
                soliPagoListNuevo.add(soliPago);
            }
            return soliPagoListNuevo;
        }
        return soliPagoList;
    }
}
