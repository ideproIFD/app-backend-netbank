package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.informix.lang.Decimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WsAxPagoCredito {
    private String numero_transaccion;
    private String fecha;
    private String signo_1;
    private String saldo_despues_pago;
}
