package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.SudCargoPrestamo;

import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 9/6/2022.
 */
public interface SudCargoPrestamoService {
    List<SudCargoPrestamo> listCargoByNumeroPrestamo (Integer numeroPrestamo);
}
