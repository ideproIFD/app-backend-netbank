package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SegMiVida {

    @JsonProperty("numero_operacion_crediticia")
    private Integer numeroOperacionCrediticia;
    @JsonProperty("nro_transaccion")
    private Integer nroTransaccion;
    @JsonProperty("nro_cuota")
    private Integer nroCuota;
    @JsonProperty("fecha_pago")
    private String fechaPago;
    @JsonProperty("id_cliente")
    private Integer idCliente;
    @JsonProperty("nro_documento")
    private String nroDocumento;
    @JsonProperty("id_cargo")
    private Integer idCargo;
    @JsonProperty("id_moneda")
    private Integer idMoneda;
    private BigDecimal monto;
}

