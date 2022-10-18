package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.datatype.jsr310.DecimalUtils;
import com.informix.lang.Decimal;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by maruquipa on 19/11/2020.
 */
@Data
public class Solicitud {

    @JsonProperty("id_sucursal")
    private Integer idSucursal;

    private String sucursal;

    @JsonProperty("id_agencia")
    private Integer idAgencia;
    private String agencia;
    private String localidad;

    @JsonProperty("cod_oficial")
    private Integer codOficial;

    @JsonProperty("oficial_nombre")
    private String  oficialNombre;

    @JsonProperty("id_tipo_credito")
    private Integer idTipoCredito;

    @JsonProperty("tipo_credito")
    private String  tipoCredito;

    @JsonProperty("id_tipo_cliente")
    private Integer idTipoCliente;

    @JsonProperty("tipo_cliente")
    private String  tipoCliente;

    @JsonProperty("tipo_operacion")
    private String  tipoOperacion;

    @JsonProperty("id_prestamo")
    private Integer idPrestamo;

    @JsonProperty("fecha_solicitud")
    private String  fechaSolicitud;

    @JsonProperty("monto_solicitado")
    private BigDecimal montoSolicitado;

    @JsonProperty("id_moneda")
    private Integer idMoneda;

    private String  moneda;

    @JsonProperty("plazo_solicitud")
    private Integer   plazoSolicitud;

    @JsonProperty("frecuencia_pago")
    private Integer   frecuenciaPago;

    @JsonProperty("id_linea")
    private Integer  idLinea;

    @JsonProperty("id_moneda_linea")
    private Integer idMonedaLinea;

    @JsonProperty("moneda_linea")
    private String  monedaLinea;

    @JsonProperty("monto_aprobado_linea")
    private BigDecimal  montoAprobadoLinea;

    @JsonProperty("fecha_aprobacion_linea")
    private String  fechaAprobacionLinea;

    @JsonProperty("tasa_anual_referencial")
    private BigDecimal tasaAnualReferencial;

    @JsonProperty("cantidad_obligados")
    private Integer  cantidadObligados;

    @JsonProperty("id_estado_prestamo")
    private Integer  idEstadoPrestamo;

    @JsonProperty("estado_prestamo")
    private String  estadoPrestamo;

}
