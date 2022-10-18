package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.*;
import com.idepro.appbackendnetbank.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by maruquipa on 19/11/2020.
 */
@Service
public class DatosSolicitudServiceImpl implements DatosSolicitudService {

    @Autowired
    private DatosSolicitudService datosSolicitudService;
    @Autowired
    private PrestamoRepository prestamoRepository;
    @Autowired
    private TransaccionService transaccionService;
    @Autowired
    private PlanPagoService planPagoService;

    @Override
    public Solicitud listaSolicitud(Integer idPrestamo) {
        Solicitud solicitud = datosSolicitudService.listaSolicitud(idPrestamo);
        return solicitud;
    }
    @Override
    public DatosOperacion listaDatosOperacion(Integer idPrestamo) {
        DatosOperacion datosOperacion = prestamoRepository.datoOperacionByIdPrestamo(idPrestamo);
        datosOperacion.setGarantiaList(listaGarantia(idPrestamo));
        datosOperacion.setIdeprotegeList(listaIdeprotege(idPrestamo));
        datosOperacion.setCargosList(listaCargo(idPrestamo));
        return datosOperacion;
    }
    public List<Garantia> listaGarantia(Integer idPrestamo) {
        List<Garantia> garantias = prestamoRepository.listGarantiaByIdPrestamo(idPrestamo);
        return garantias;
    }

    public List<Ideprotege> listaIdeprotege(Integer idPrestamo) {
        List<Ideprotege> ideprotege = prestamoRepository.ideprotegeByIdPrestamo(idPrestamo);
        return ideprotege;
    }

    public List<Cargo> listaCargo(Integer idPrestamo) {
        List<Cargo> cargos = prestamoRepository.cargoByIdPrestamo(idPrestamo);
        return cargos;
    }

    @Override
    public DatosSolicitud listaDatosSolicitud(Integer idPrestamo) {
        DatosSolicitud datosOperacion = prestamoRepository.listSolicitudByIdPrestamo(idPrestamo);
        if(datosOperacion != null){
            datosOperacion.setCargosList(listaCargo(idPrestamo));
            datosOperacion.setCuotaList(planPagoService.listPlanPagoByIdPrestamo(idPrestamo));
            datosOperacion.setTransaccionList(transaccionService.listTransaccionCargosByIdPrestamo(idPrestamo));
            return datosOperacion;
        }else
            return null;
    }
}
