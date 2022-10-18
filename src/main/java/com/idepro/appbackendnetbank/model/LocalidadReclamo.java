package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 9/11/2021.
 */
@Data
public class LocalidadReclamo {
    @JsonProperty("id_localidad")
    private Integer idLocalidad;
    private String localidad;
    @JsonProperty("id_responsable")
    private String idResponsable;
    private String responsable;
    @JsonProperty("id_tipo_oficina")
    private Integer idTipoOficina;
    @JsonProperty("tipo_oficina")
    private String tipoOficina;
}
