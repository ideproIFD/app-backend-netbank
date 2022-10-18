package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 5/4/2022.
 */
@Data
public class CdCredito {
    @JsonProperty("id_credito")
    private Integer idCredito;
    @JsonProperty("id_cliente")
    private Integer idCliente;
    @JsonProperty("pago_para_estar_al_dia")
    private BigDecimal pagoParaEstarAlDia;
    @JsonProperty("valor_cuota")
    private BigDecimal valorCuota;
    @JsonProperty("dias_capital_mora")
    private Integer diasCapitalMora;
    @JsonProperty("fecha_otorgado")
    private String fechaOtorgado;
    @JsonProperty("fecha_desembolso")
    private String fechaDesembolso;
    @JsonProperty("fecha_vencimiento")
    private String fechaVencimiento;

    @JsonProperty("saldo_normal")
    private BigDecimal saldoNormal;
    @JsonProperty("saldo_diferido")
    private BigDecimal saldoDiferido;
    @JsonProperty("saldo_total")
    private BigDecimal saldoTotal;
    @JsonProperty("monto_otorgado")
    private BigDecimal montoOtorgado;
    @JsonProperty("capital_mora")
    private BigDecimal capitalMora;
    @JsonProperty("ultima_fecha_pago")
    private String ultimaFechaPago;
    private Integer plazo;
    private Integer frecuencia;
    @JsonProperty("cantidad_cuotas")
    private Integer cantidadCuotas;
    @JsonProperty("id_linea_credito")
    private Integer idLineaCredito;
    @JsonProperty("tasa_interes")
    private BigDecimal tasaInteres;
    @JsonProperty("id_agencia")
    private Integer idAgencia;
    @JsonProperty("nota_cliente")
    private String notaCliente;
    @JsonProperty("id_estado")
    private Integer idEstado;
    private String estado;
}
