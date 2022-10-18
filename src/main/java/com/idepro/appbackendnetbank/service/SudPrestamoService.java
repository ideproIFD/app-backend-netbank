package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.SudCliente;
import com.idepro.appbackendnetbank.model.SudPrestamo;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 23/5/2022.
 */
public interface SudPrestamoService {

    List<SudPrestamo> listPrestamosByCodigoCliente(String codigoCliente);
}
