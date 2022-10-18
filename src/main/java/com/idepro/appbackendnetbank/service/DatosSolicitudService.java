package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.DatosOperacion;
import com.idepro.appbackendnetbank.model.DatosSolicitud;
import com.idepro.appbackendnetbank.model.Solicitud;

/**
 * Created by maruquipa on 19/11/2020.
 */
public interface DatosSolicitudService {

    Solicitud listaSolicitud(Integer idPrestamo);
    DatosOperacion listaDatosOperacion(Integer idPrestamo);
    DatosSolicitud listaDatosSolicitud(Integer idPrestamo);
}
