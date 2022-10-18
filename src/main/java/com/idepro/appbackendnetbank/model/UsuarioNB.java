package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class UsuarioNB {
    @JsonProperty("id_sucursal")
    private Integer idSucursal;
    private String sucursal;
    @JsonProperty("id_agencia")
    private Integer idAgencia;
    private String agencia;
    private Integer firma;
    private String  nombre;
    private String  usuario;
    private String estado;

    public UsuarioNB() {
    }
}
