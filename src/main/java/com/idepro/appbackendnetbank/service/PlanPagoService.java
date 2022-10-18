package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.PlanPago;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 25/3/2022.
 */
public interface PlanPagoService {

    List<PlanPago> listPlanPagoByIdPrestamo(Integer idPrestamo);
}
