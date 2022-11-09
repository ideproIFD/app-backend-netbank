package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BcpConsulta {
    @JsonProperty("cod_error")
    private String codError;
    private String descripcion;
    @JsonProperty("codigo_busqueda")
    private String codigoBusqueda;
    @JsonProperty("cod_servicio")
    private String codServicio;
    @JsonProperty("importe_adeudado")
    private BigDecimal importeAdeudado;
    @JsonProperty("importe_adeudado_decimal")
    private BigDecimal importeAdeudadoDecimal;
    @JsonProperty("importe_minimo")
    private BigDecimal importeMinimo;
    @JsonProperty("importe_minimo_decimal")
    private BigDecimal importeMinimoDecimal;
    @JsonProperty("importe_comision")
    private BigDecimal importeComision;
    @JsonProperty("nombre_cliente")
    private String nombreCliente;

    @JsonProperty("pagos")
    private List<BcpConsultaPago> pagos;

}
