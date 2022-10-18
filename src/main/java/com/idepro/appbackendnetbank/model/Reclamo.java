package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 15/11/2021.
 */
@Data
public class Reclamo {
    @JsonProperty("numero_reclamo")
    private Integer numeroReclamo;
    @JsonProperty("id_tipologia")
    private Integer idTipologia;
    private String tipologia;
    @JsonProperty("id_subtipologia")
    private Integer idSubTipologia;
    private String subTipologia;
    @JsonProperty("tipo_entidad")
    private String tipoEntidad;
    @JsonProperty("codigo_entidad")
    private String codigoEntidad;
    @JsonProperty("fecha_reclamo")
    private String fechaReclamo;
    @JsonProperty("tipo_oficina")
    private Integer tipoOficina;
    @JsonProperty("tipo_oficina_descripcion")
    private String tipoOficinaDescripcion;
    @JsonProperty("localidad_oficina")
    private String localidadOficina;
    @JsonProperty("localidad_oficina_descripcion")
    private String localidadOficinaDescripcion;
    private String glosa;
    @JsonProperty("glosa_adicional")
    private String glosaAdicional;
    private BigDecimal importe;
    private String moneda;
    @JsonProperty("moneda_descripcion")
    private String monedaDescripcion;
    @JsonProperty("moneda_extranjera")
    private String monedaExtranjera;
    @JsonProperty("moneda_extranjera_descripcion")
    private String monedaExtranjeraDescripcion;
    @JsonProperty("plazo_dias")
    private Integer plazoDias;
    @JsonProperty("plazo_original_dias")
    private Integer plazoOriginalDias;
    @JsonProperty("fecha_vencimiento_actual")
    private String fechaVencimientoActual;
    @JsonProperty("fecha_vencimiento_original")
    private String fechaVencimientoOriginal;
    @JsonProperty("usuario_contacto")
    private String usuarioContacto;
    private String responsable;
    @JsonProperty("fecha_solucion")
    private String fechaSolucion;
    @JsonProperty("cite_documento")
    private String citeDocumento;
    @JsonProperty("descripcion_respuesta")
    private String descripcionRespuesta;
    @JsonProperty("codigo_solucion")
    private String codigoSolucion;
    private Integer estado;
    @JsonProperty("estado_descripcion")
    private String estadoDescripcion;
    private String contacto;
    @JsonProperty("tipo_documento")
    private String tipoDocumento;
    @JsonProperty("numero_documento")
    private String numeroDocumento;
    @JsonProperty("correlativo_documento")
    private Integer correlativoDocumento;
    @JsonProperty("extencion_documento")
    private String extencionDocumento;
    private String nombre;
    private String apellidos;
    @JsonProperty("direccion_1")
    private String direccion1;
    @JsonProperty("direccion_2")
    private String direccion2;
    @JsonProperty("telefono_fijo")
    private String telefonoFijo;
    @JsonProperty("telefono_celular")
    private String telefonoCelular;
    private String email;
    private Integer plaza;
    private Integer agencia;
    @JsonProperty("marca_baja")
    private Integer marcaBaja;
    private String usuario;
    @JsonProperty("fecha_proceso")
    private String fechaProceso;
    private String hora;
    @JsonProperty("codigo_asfi")
    private Integer codigoAsfi;

    @JsonProperty("tipo_reclamante")
    private String tipoReclamante;
    @JsonProperty("numero_testimonio")
    private Integer numeroTestimonio;
    @JsonProperty("representante_legal")
    private String representanteLegal;
    private String fecha;
    @JsonProperty("modo_respuesta")
    private String modoRespuesta;
    @JsonProperty("tipo_credito")
    private String tipoCredito;
    @JsonProperty("nombre_oficial")
    private String nombreOficial;

}
