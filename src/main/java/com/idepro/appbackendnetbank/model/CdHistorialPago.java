package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 6/4/2022.
 */
@Data
public class CdHistorialPago {
    @JsonProperty("id_credito")
    private Integer idCredito;
    @JsonProperty("fecha_pago")
    private String fechaPago;
    private BigDecimal monto;
}
