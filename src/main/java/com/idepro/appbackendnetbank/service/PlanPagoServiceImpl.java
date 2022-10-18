package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.PlanPago;
import com.idepro.appbackendnetbank.repository.PlanPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 25/3/2022.
 */
@Service
public class PlanPagoServiceImpl implements PlanPagoService {

    @Autowired
    private PlanPagoRepository planPagoRepository;

    @Override
    public List<PlanPago> listPlanPagoByIdPrestamo(Integer idPrestamo) {
        List<PlanPago> planPagoList = new ArrayList<>();
        if(idPrestamo != null){
            planPagoList = planPagoRepository.listPlanPagoByIdPrestamo(idPrestamo);
        }
        return planPagoList;
    }
}
