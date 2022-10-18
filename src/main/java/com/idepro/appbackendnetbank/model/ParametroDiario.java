package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 26/7/2022.
 */
@Data
@JsonPropertyOrder({ "nombreEmpresa", "nit", "direccion1", "direccion2", "fechaSistema", "tipoCambio",
        "tipoCambioOficial", "tipoCambioCompra", "tipoCambioVenta", "ufv"})
public class ParametroDiario {

    @JsonProperty("nombre_empresa")
    private String nombreEmpresa;
    private String nit;
    private String direccion1;
    private String direccion2;
    @JsonProperty("fecha_sistema")
    private String fechaSistema;
    @JsonProperty("tipo_cambio")
    private BigDecimal tipoCambio;
    @JsonProperty("tipo_cambio_oficial")
    private BigDecimal tipoCambioOficial;
    @JsonProperty("tipo_cambio_compra")
    private BigDecimal tipoCambioCompra;
    @JsonProperty("tipo_cambio_venta")
    private BigDecimal tipoCambioVenta;
    private BigDecimal ufv;

}
