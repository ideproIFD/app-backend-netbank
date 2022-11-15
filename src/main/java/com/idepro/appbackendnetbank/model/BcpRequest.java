package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BcpRequest {

    // BCP
    private String entidad;
    private String contraseña;
    @JsonProperty("cod_servicio")
    private String codServicio;
    @JsonProperty("codigo_busqueda")
    private String codigoBusqueda;
    @JsonProperty("id_transaccion")
    private BigDecimal idTransaccion;
//    @JsonProperty("id_transaccion")
//    private String idTransaccion;
    @JsonProperty("fecha_pago")
    private String fechaPago;
    @JsonProperty("monto_total")
    private String montoTotal;
    @JsonProperty("nombre_factura")
    private String nombreFactura;
    private String nit;
    @JsonProperty("lugar_pago")
    private String lugarPago;
    @JsonProperty("detalle_pago")
    private List<BcpRequestDetallePago> detallePago;
    @JsonProperty("id_transaccion_empresa")
    private Integer idTransaccionEmpresa;
//    @JsonProperty("id_reversion")
//    private String  idReversion;
    @JsonProperty("id_reversion")
    private Integer  idReversion;
    @JsonProperty("fecha_reversion")
    private String fechaReversion;
    @JsonProperty("fecha_inicio")
    private String fechaInicio;
    @JsonProperty("fecha_final")
    private String fechaFinal;


    public BcpRequest() {
    }

    public String requestConsulta(BcpRequest request) {
        String mensaje;
        if (request.getEntidad() != null && request.getCodigoBusqueda() != null && request.getCodServicio() != null) {
            return null;
        } else {
            mensaje = (request.getEntidad() != null ? "" : "entidad ") +
                    (request.getCodigoBusqueda() != null ? "" : "codigo_busqueda ") +
                    (request.getCodServicio() != null ? "" : "cod_servicio ");
            return mensaje;
        }
    }

    public String requestPago(BcpRequest request) {
        String mensaje;
        if (request.getEntidad() != null && request.getIdTransaccion() != null && request.getFechaPago() != null && request.getCodigoBusqueda() != null && request.getMontoTotal() != null ) {
            return null;
        } else {
            mensaje = (request.getEntidad() != null ? "" : "entidad ") +
                    (request.getIdTransaccion() != null ? "" : "id_transaccion ") +
                    (request.getFechaPago() != null ? "" : "fecha_pago ") +
                    (request.getCodigoBusqueda() != null ? "" : "codigo_busqueda ") +
                    (request.getMontoTotal() != null ? "" : "monto_total");
            return mensaje;
        }
    }
    public String requestReversion(BcpRequest request) {
        String mensaje;
        if (request.getEntidad() != null && request.getCodigoBusqueda() != null && request.getIdTransaccionEmpresa() != null && request.getIdReversion() != null && request.getFechaReversion() != null) {
            return null;
        } else {
            mensaje = (request.getEntidad() != null ? "" : "entidad ") +
                    (request.getCodigoBusqueda() != null ? "" : "cod_servicio ") +
                    (request.getIdTransaccionEmpresa() != null ? "" : "id_transaccion_empresa ") +
                    (request.getIdReversion() != null ? "" : "id_reversion ") +
                    (request.getFechaReversion() != null ? "" : "fecha_reversion");
            return mensaje;
        }
    }
}
