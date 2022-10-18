package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 23/5/2022.
 */
@Data
@JsonPropertyOrder({ "numeroPrestamo", "codigoCliente", "producto", "idCaedecDestino", "caedecDestino", "destino",
        "destinoParticular", "moneda", "montoDesembolso", "montoDesembolsoBs", "fechaDesembolso", "fechaUltimoPago",
        "formaPago", "plazoDias", "periodicidadPagoCapitalDias", "periodicidadPagoInteresDias", "diaPago",
        "saldo", "saldoBs", "estado" })
public class SudPrestamo {
    @JsonProperty("numero_prestamo")
    private Integer numeroPrestamo;
    @JsonProperty("codigo_cliente")
    private Integer codigoCliente;
    private String producto;
    @JsonProperty("id_caedec_destino")
    private Integer idCaedecDestino;
    @JsonProperty("caedec_destino")
    private String caedecDestino;
    private String destino;
    @JsonProperty("destino_particular")
    private String destinoParticular;
    private String moneda;
    @JsonProperty("monto_desembolso")
    private BigDecimal montoDesembolso;
    @JsonProperty("monto_desembolso_bs")
    private BigDecimal montoDesembolsoBs;
    @JsonProperty("fecha_desembolso")
    private String fechaDesembolso;
    @JsonProperty("fecha_ultimo_pago")
    private String fechaUltimoPago;
    @JsonProperty("forma_pago")
    private String formaPago;
    @JsonProperty("plazo_dias")
    private Integer plazoDias;
    @JsonProperty("periodicidad_pago_capital_dias")
    private Integer periodicidadPagoCapitalDias;
    @JsonProperty("periodicidad_pago_interes_dias")
    private Integer periodicidadPagoInteresDias;
    @JsonProperty("dia_pago")
    private Integer diaPago;
    private BigDecimal saldo;
    @JsonProperty("saldo_bs")
    private BigDecimal saldoBs;
    private String estado;
}
