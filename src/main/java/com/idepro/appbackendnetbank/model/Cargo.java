package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by maruquipa on 02/12/2020.
 */
@Data
public class Cargo {
    @JsonProperty("id_cargo")
    private Integer idCargo;
    private String cargo;
    @JsonProperty("monto_cargo_prestamo")
    private BigDecimal montoCargoPrestamo;
    @JsonProperty("moneda_cargo")
    private String monedaCargo;

    public Cargo(){

    }
}
