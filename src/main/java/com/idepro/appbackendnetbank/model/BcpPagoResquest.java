package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BcpPagoResquest {
    @JsonProperty("canal")
    private Integer canal;
    @JsonProperty("codigo_cliente")
    private String codigoCliente;
    @JsonProperty("codigo_apoderado")
    private String codigoApoderado;
    @JsonProperty("numero_cc")
    private String numeroCc;
    @JsonProperty("numero_credito")
    private String numeroCredito;
    @JsonProperty("fecha")
    private String fecha;
    @JsonProperty("moneda")
    private String moneda;
    @JsonProperty("signo_1")
    private String signo1;
    @JsonProperty("monto_pago")
    private String montoPago;
}
