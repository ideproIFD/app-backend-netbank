package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 3/12/2021.
 */
@Data
@JsonPropertyOrder({ "fechaCorte", "codigoEnvio", "numeroReclamo", "gestion", "fechaReclamo", "tipoDocumento", "numeroDocumento", "nombre", "apellidos", "tipoOficina", "localidadOficina", "ubicacion", "idTipologia", "idSubTipologia", "glosa", "importe", "moneda", "monedaExtranjera", "usuarioContacto", "gestionAsfi", "codigoAsfi", "fechaSolucion", "descripcionRespuesta", "resultadoReclamo", "telefono", "tipoCredito", "email", "responsable"})
public class ReporteReclamoDiferido {

    @JsonProperty("fecha_corte")
    private String fechaCorte;
    @JsonProperty("codigo_envio")
    private String codigoEnvio;
    @JsonProperty("numero_reclamo")
    private Integer numeroReclamo;
    private String gestion;
    @JsonProperty("fecha_reclamo")
    private String fechaReclamo;
    @JsonProperty("tipo_documento")
    private String tipoDocumento;
    @JsonProperty("numero_documento")
    private String numeroDocumento;
    private String nombre;
    private String apellidos;
    @JsonProperty("tipo_oficina")
    private String tipoOficina;
    @JsonProperty("localidad_oficina")
    private String localidadOficina;
    private String ubicacion;
    @JsonProperty("id_tipologia")
    private Integer idTipologia;
    @JsonProperty("id_sub_tipologia")
    private Integer idSubTipologia;
    private String glosa;
    private BigDecimal importe;
    private String moneda;
    @JsonProperty("moneda_extranjera")
    private String monedaExtranjera;
    @JsonProperty("usuario_contacto")
    private String usuarioContacto;
    @JsonProperty("gestion_asfi")
    private String gestionAsfi;
    @JsonProperty("codigo_asfi")
    private Integer codigoAsfi;
    @JsonProperty("fecha_solucion")
    private String fechaSolucion;
    @JsonProperty("descripcion_respuesta")
    private String descripcionRespuesta;
    @JsonProperty("resultado_reclamo")
    private String resultadoReclamo;
    private String telefono;
    @JsonProperty("tipo_credito")
    private String tipoCredito;
    private String email;
    private String responsable;
}
