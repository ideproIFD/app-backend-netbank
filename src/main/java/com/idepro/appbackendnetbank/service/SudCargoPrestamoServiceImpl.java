package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.SudCargoPrestamo;
import com.idepro.appbackendnetbank.repository.SudCargoPrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 9/6/2022.
 */
@Service
public class SudCargoPrestamoServiceImpl implements SudCargoPrestamoService {

    @Autowired
    private SudCargoPrestamoRepository sudCargoPrestamoRepository;

    @Override
    public List<SudCargoPrestamo> listCargoByNumeroPrestamo(Integer numeroPrestamo) {
        List<SudCargoPrestamo> cargoPrestamoList = sudCargoPrestamoRepository.listCargoByNumeroPrestamo(numeroPrestamo);
        if(cargoPrestamoList == null){
            cargoPrestamoList = new ArrayList<>();
        }
        return cargoPrestamoList;
    }
}
