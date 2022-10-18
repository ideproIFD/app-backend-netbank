package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.CdHistorialPago;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 6/4/2022.
 */
public interface CdHistorialPagoService {
    List<CdHistorialPago> listAll();

    List<CdHistorialPago> listByFecha(String fecha);
}
