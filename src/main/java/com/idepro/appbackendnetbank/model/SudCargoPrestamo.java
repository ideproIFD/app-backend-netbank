package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 9/6/2022.
 */
@Data
@JsonPropertyOrder({ "numeroPrestamo", "idCargo", "cargo", "monto", "usuario", "fechaProceso", "hora"})
public class SudCargoPrestamo {
    @JsonProperty("numero_prestamo")
    private Integer numeroPrestamo;
    @JsonProperty("id_cargo")
    private Integer idCargo;
    private String cargo;
    private BigDecimal monto;
    private String usuario;
    @JsonProperty("fecha_proceso")
    private String fechaProceso;
    private String hora;
}
