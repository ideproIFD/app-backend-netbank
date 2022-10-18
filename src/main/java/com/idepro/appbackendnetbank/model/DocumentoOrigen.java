package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 9/11/2021.
 */
@Data
public class DocumentoOrigen {
    @JsonProperty("id_origen")
    private String idOrigen;
    private String descripcion;
}
