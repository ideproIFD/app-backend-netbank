package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Create by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 18/11/2020.
 */
@Data
public class Prestamo {

    @JsonProperty("id_prestamo")
    private Integer idPrestamo;
    @JsonProperty("id_estado")
    private Integer idEstado;
    private String estado;
}
