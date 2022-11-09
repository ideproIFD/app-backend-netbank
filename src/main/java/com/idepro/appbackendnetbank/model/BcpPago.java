package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BcpPago {
    @JsonProperty("cod_error")
    private String codError;
    private String descripcion;
    @JsonProperty("codigo_busqueda")
    private String codigoBusqueda;
    @JsonProperty("id_transaccion_empresa")
    private BigDecimal idTransaccionEmpresa;
    @JsonProperty("id_transaccion_entidad")
    private String idTransaccionEntidad;
    @JsonProperty("razon_social")
    private String razonSocial;
    @JsonProperty("casa_matriz")
    private String casaMatriz;
    private String direccion;
    private String telefono;
    @JsonProperty("ciudad_dosificacion")
    private String ciudadDosificacion;
    @JsonProperty("NIT")
    private String nit;
    @JsonProperty("nro_autorizacion")
    private String nroAutorizacion;
    @JsonProperty("nro_factura")
    private String nroFactura;
    @JsonProperty("actividad_economica")
    private String actividadEconomica;
    @JsonProperty("hora_emision_fac")
    private String horaEmisionFac;
    @JsonProperty("fecha_Emision_Fac")
    private String fechaEmisionFac;
    @JsonProperty("razon_social")
    private String RazonSocial;
    @JsonProperty("NIT2")
    private String nit_;
    @JsonProperty("detalle_factura")
    private String detalleFactura;
    @JsonProperty("importe_original")
    private String importeOriginal;
    @JsonProperty("tipo_cambio")
    private String tipoCambio;
    @JsonProperty("importe_total")
    private Integer importeTotal;
    @JsonProperty("literal_importe_total")
    private String literalImporteTotal;
    @JsonProperty("codigo_control")
    private String codigoControl;
    @JsonProperty("fecha_limite_Emision")
    private String fechaLimEmision;
    @JsonProperty("cadena_qr")
    private String cadenaQR;
}
