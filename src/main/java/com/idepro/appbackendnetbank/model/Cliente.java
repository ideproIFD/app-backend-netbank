package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Create by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 18/11/2020.
 */
@Data
public class Cliente {

    @JsonProperty("id_cliente")
    private Integer idCliente;
    private String nombre;
    @JsonProperty("apellido_paterno")
    private String apellidoPaterno;
    @JsonProperty("apellido_materno")
    private String apellidoMaterno;
    @JsonProperty("apellido_casada")
    private String apellidoCasada;
    @JsonProperty("direccion_domicilio")
    private String direccionDomicilio;
    @JsonProperty("direccion_negocio")
    private String direccionNegocio;
    @JsonProperty("idEstado_civil")
    private Integer idEstadoCivil;
    @JsonProperty("estado_civil")
    private String estadoCivil;
    @JsonProperty("id_sexo")
    private Integer idSexo;
    private String sexo;
    @JsonProperty("numero_documento")
    private String numeroDocumento;
    @JsonProperty("id_tipo_documento")
    private Integer idTipoDocumento;
    @JsonProperty("tipo_documento")
    private String tipoDocumento;
    @JsonProperty("complemento_documento")
    private String complementoDocumento;
    private String pais;
    @JsonProperty("fecha_nacimiento")
    private String fechaNacimiento;
    @JsonProperty("id_caedec")
    private Integer idCaedec;
    private String caedec;
    private String actividad;
    @JsonProperty("fecha_registro")
    private String fechaRegistro;
    private String celular;
    @JsonProperty("telefono_1")
    private String telefono1;
    @JsonProperty("telefono_2")
    private String telefono2;



    @JsonProperty("prestamos_anteriores")
    private List<Prestamo> prestamoList;

    public Cliente() {
    }
}
