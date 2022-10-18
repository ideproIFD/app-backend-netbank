package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.BcpConsulta;
import com.idepro.appbackendnetbank.model.BcpPago;
import com.idepro.appbackendnetbank.model.BcpRequest;
import com.idepro.appbackendnetbank.model.BcpReversion;

import java.io.IOException;

public interface BcpConsultaService {
    BcpConsulta findByIdPrestamoCodServicio(Integer idPrestamo, String codigoServicio) throws IOException;

    BcpPago findByIdPagoCodServicio(BcpRequest requestInput) throws IOException;

    BcpReversion findByIdReversionCodServicio(BcpRequest requestInput) throws IOException;
}
