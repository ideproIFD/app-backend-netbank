package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BcpEstadoTransaccion {
    @JsonProperty("cod_error")
    private String codError;
    private String descripcion;
    @JsonProperty("codigo_busqueda")
    private String codigoBusqueda;
    @JsonProperty("id_transaccion_empresa")
    private String idTransaccionEmpresa;
    @JsonProperty("id_transaccion_entidad")
    private String idTransaccionEntidad;
    @JsonProperty("estado")
    private String estado;
    @JsonProperty("fecha")
    private String fecha;
    @JsonProperty("hora")
    private String hora;
    @JsonProperty("moneda")
    private Integer moneda;
    @JsonProperty("monto")
    private BigDecimal monto;
}

