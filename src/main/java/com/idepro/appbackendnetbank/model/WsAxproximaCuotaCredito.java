package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.informix.lang.Decimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WsAxproximaCuotaCredito {
    private Integer capital;
    private Integer diasMora;
    private String estado;
    private String fechaDeIncumplimiento;
    private String moneda;
    private String montoDesembolsado;
    private String montoProximaCuota;
    private String numeroCredito;
    private String tipoCredito;
    private String header;
}
