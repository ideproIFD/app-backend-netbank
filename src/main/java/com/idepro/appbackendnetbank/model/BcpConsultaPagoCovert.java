package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class BcpConsultaPagoCovert {
    @JsonProperty("fecha_vencimiento")
    private String fechaVencimiento;
    @JsonProperty("importe_cuota")
    private BigDecimal importeCuota;
    @JsonProperty("importe_cuota_decimal")
    private BigDecimal importeCuotaDecimal;
    @JsonProperty("importe_adeudado_decimal")
    private BigDecimal importeAdeudadoDecimal;
}
