package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.*;

import java.io.IOException;
import java.util.List;

public interface BcpConsultaService {
    BcpConsulta findByIdPrestamoCodServicio(Integer idPrestamo, String codigoServicio) throws IOException;

    BcpPago findByIdPagoCodServicio(BcpRequest requestInput) throws IOException;

    BcpReversion findByIdReversionCodServicio(BcpRequest requestInput) throws IOException;

    BcpEstadoTransaccion findByIdEstadoTransaccion(String idPrestamo, String fechaPago);

    List<BcpEstadoTransaccion> findByIdHistorialTransaccion(String fechaInicio, String fechaFinal, String idTransaccionEnpresa) throws IOException;
}