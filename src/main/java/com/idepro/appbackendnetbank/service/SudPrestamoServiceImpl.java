package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.SudCliente;
import com.idepro.appbackendnetbank.model.SudCuotaPagada;
import com.idepro.appbackendnetbank.model.SudPlanPago;
import com.idepro.appbackendnetbank.model.SudPrestamo;
import com.idepro.appbackendnetbank.repository.SudClienteRepository;
import com.idepro.appbackendnetbank.repository.SudCuotaPagadaRepository;
import com.idepro.appbackendnetbank.repository.SudPlanPagoRepository;
import com.idepro.appbackendnetbank.repository.SudPrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 23/5/2022.
 */
@Service
public class SudPrestamoServiceImpl implements SudPrestamoService {

    @Autowired
    private SudPrestamoRepository sudPrestamoRepository;
    @Autowired
    private SudCuotaPagadaRepository sudCuotaPagadaRepository;
    @Autowired
    private SudPlanPagoRepository sudPlanPagoRepository;
    @Autowired
    private SudClienteRepository sudClienteRepository;

    @Override
    public List<SudPrestamo> listPrestamosByCodigoCliente(String codigoCliente) {

        List<SudPrestamo> sudPrestamoList = sudPrestamoRepository.listPrestamoByCodigoCliente(codigoCliente);
        if (sudPrestamoList.size() == 0)
            sudPrestamoList = new ArrayList<>();
//        else {
//            for (SudPrestamo prestamo : sudPrestamoList) {
//                List<SudCuotaPagada> sudCuotaPagadaList = sudCuotaPagadaRepository.listCuotaPagadaByNumeroPrestamo(prestamo.getNumeroPrestamo());
//                if (sudCuotaPagadaList.size() == 0)
//                    sudCuotaPagadaList = new ArrayList<>();
//                prestamo.setCuotaPagadaList(sudCuotaPagadaList);
//
//                List<SudPlanPago> sudPlanPagoList = sudPlanPagoRepository.listPlanPagoByNumeroPrestamo(prestamo.getNumeroPrestamo());
//                if (sudPlanPagoList.size() == 0)
//                    sudPlanPagoList = new ArrayList<>();
//                prestamo.setPlanPagoList(sudPlanPagoList);
//            }
//        }
        return sudPrestamoList;
    }
}
