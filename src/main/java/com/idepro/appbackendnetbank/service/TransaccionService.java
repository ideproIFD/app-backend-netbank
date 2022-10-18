package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.Transaccion;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 24/3/2022.
 */
public interface TransaccionService {

    List<Transaccion> listTransaccionByIdPrestamo(Integer idPrestamo);

    List<Transaccion> listTransaccionCargosByIdPrestamo(Integer idPrestamo);
}
