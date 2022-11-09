package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BcpHistorialPago {
    @JsonProperty("cod_error")
    private String codError;
    private String descripcion;
    @JsonProperty("id_transaccion_empresa")
    private String idTransaccionEmpresa;
    @JsonProperty("id_transaccion_entidad")
    private String idTransaccionEntidad;
    @JsonProperty("codigo_busqueda")
    private String codigoBusqueda;
    @JsonProperty("id_estado")
    private String idEstado;
    @JsonProperty("monto")
    private BigDecimal monto;
    @JsonProperty("tipo_operacion")
    private String tipoOperacion;
    @JsonProperty("fecha")
    private String fecha;
}
