package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BcpRequestDetallePago {
    @JsonProperty("numero_cuota")
    private Integer numeroCuota;
    @JsonProperty("importe_cuota")
    private BigDecimal importeCuota;
}
