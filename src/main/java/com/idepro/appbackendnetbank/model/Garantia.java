package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by maruquipa on 23/11/2020.
 */
@Data
public class Garantia {
    @JsonProperty("tipo_garantia")
    private Integer tipoGarantia;
    private String garantia;
    private BigDecimal monto;
    @JsonProperty("id_moneda")
    private Integer idMoneda;
    private String moneda;

}
