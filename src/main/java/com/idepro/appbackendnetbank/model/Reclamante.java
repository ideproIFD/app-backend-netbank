package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 15/11/2021.
 */
@Data
public class Reclamante {
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
    @JsonProperty("marca_baja")
    private Integer marcaBaja;
    private String usuario;
    @JsonProperty("fecha_proceso")
    private String fechaProceso;
    private String hora;
}
