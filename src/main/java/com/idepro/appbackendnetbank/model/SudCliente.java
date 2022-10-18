package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 7/6/2022.
 */
@Data
@JsonPropertyOrder({ "codigoCliente", "nombre1", "nombre_2", "apellido1", "apellido2", "apellidoCasada", "nombreCompleto", "numeroDocumentoCompleto",
        "numeroDocumento", "extencionDocumento", "complementoDocumento", "genero", "lugarNacimiento", "fechaNacimiento", "idCaedec", "caedec",
        "direccion", "telefono", "celular", "saldoTotalBs", "prestamo_list"})
public class SudCliente {
    @JsonProperty("codigo_cliente")
    private Integer codigoCliente;
    @JsonProperty("nombre_1")
    private String nombre1;
    @JsonProperty("nombre_2")
    private String nombre2;
    @JsonProperty("apellido_1")
    private String apellido1;
    @JsonProperty("apellido_2")
    private String apellido2;
    @JsonProperty("apellido_casada")
    private String apellidoCasada;
    @JsonProperty("nombre_completo")
    private String nombreCompleto;
    @JsonProperty("numero_documento_completo")
    private String numeroDocumentoCompleto;
    @JsonProperty("numero_documento")
    private String numeroDocumento;
    @JsonProperty("extencion_documento")
    private String extencionDocumento;
    @JsonProperty("complemento_documento")
    private String complementoDocumento;
    private String genero;
    @JsonProperty("lugar_nacimiento")
    private String lugarNacimiento;
    @JsonProperty("fecha_nacimiento")
    private String fechaNacimiento;
    @JsonProperty("id_caedec")
    private String idCaedec;
    private String caedec;
    private String direccion;
    private String telefono;
    private String celular;
    @JsonProperty("saldo_total_bs")
    private BigDecimal saldoTotalBs;
    @JsonProperty("prestamo_list")
    private List<SudPrestamo> prestamoList;
}
