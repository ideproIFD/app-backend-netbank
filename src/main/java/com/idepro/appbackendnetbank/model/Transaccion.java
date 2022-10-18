package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 24/3/2022.
 */
@Data
public class Transaccion {
    @JsonProperty("id_transaccion")
    private Integer idTransaccion;
    private String fecha;
    private Integer concepto;
    private String descripcion;
    private BigDecimal importe;
}
