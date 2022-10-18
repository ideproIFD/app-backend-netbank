package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by maruquipa on 25/11/2020.
 */
@Data
public class Ideprotege {
    private Integer id;
    private String tipo;
    private BigDecimal monto;
    @JsonProperty("dato_1")
    private String dato1;
    @JsonProperty("dato_2")
    private String dato2;
    @JsonProperty("dato_3")
    private String dato3;
    @JsonProperty("dato_4")
    private String dato4;
    @JsonProperty("dato_5")
    private String dato5;
    @JsonProperty("dato_6")
    private String dato6;
    @JsonProperty("dato_7")
    private String dato7;
    @JsonProperty("dato_8")
    private String dato8;
    @JsonProperty("id_tipo_pago")
    private Integer idTipoPago;
    @JsonProperty("tipo_pago")
    private String tipoPago;
    @JsonProperty("id_tipo_vehiculo")
    private String idTipoVehiculo;
    @JsonProperty("tipo_vehiculo")
    private String tipoVehiculo;
    @JsonProperty("fecha_proceso")
    private String fechaProceso;
    private BigDecimal tasa;
    private String origen;
    private BigDecimal valor;
}
