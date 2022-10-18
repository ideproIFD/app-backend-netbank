package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class BcpConsultaPago {
    @JsonProperty("numero_cuota")
    private Integer numeroCuota;
    @JsonProperty("detalle_cuota")
    private String detalleCuota;
    @JsonProperty("fecha_vencimiento")
    private String fechaVencimiento;
    @JsonProperty("importe_cuota")
    private BigDecimal importeCuota;
    @JsonProperty("importe_cuota_decimal")
    private BigDecimal importeCuotaDecimal;
    @JsonProperty("importe_minimo_cuota")
    private BigDecimal importeMinimoCuota;
    @JsonProperty("mora_cuota")
    private BigDecimal moraCuota;
    @JsonProperty("importe_comision")
    private BigDecimal importeComision;
}
