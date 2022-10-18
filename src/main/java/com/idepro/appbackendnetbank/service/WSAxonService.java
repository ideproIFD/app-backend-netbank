package com.idepro.appbackendnetbank.service;

import com.idepro.appbackendnetbank.model.BcpCliente;
import com.idepro.appbackendnetbank.model.BcpConsultaPagoCovert;
import com.idepro.appbackendnetbank.model.BcpRequest;

import java.io.IOException;
import java.math.BigDecimal;


public interface WSAxonService {
    BigDecimal proximaCuotafindByCanalIdClinteIdApoderadoIdPrestamo(Integer canal, Integer idCliente, String plaza, Integer idApoderado, Integer idPrestamo) throws IOException;

    BcpConsultaPagoCovert proximaCuotafindByConversion(Integer canal, Integer idCliente, String plaza, Integer idApoderado, Integer idPrestamo) throws IOException;

    BigDecimal pagoCreditofindNumeroTransaccion(BcpRequest requestBody, BcpCliente cliente) throws IOException;

    String reversionPagoCreditofindNumeroTransaccion(BcpRequest requestBody) throws IOException;
}
