package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 28/3/2022.
 */
@Data
public class CdCliente {

    @JsonProperty("id_cliente")
    private Integer idCliente;
    private String nombre;
    private String telefono;
    private String direccion;
    private String latitud;
    private String longitud;
}
