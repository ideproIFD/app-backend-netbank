package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BcpCliente {

    @JsonProperty("id_cliente")
    private Integer idCliente;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("plaza")
    private String plaza;
}
