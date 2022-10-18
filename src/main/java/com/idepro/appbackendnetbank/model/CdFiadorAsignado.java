package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CdFiadorAsignado {
    @JsonProperty("id_fiador")
    private Integer idFiador;
    @JsonProperty("id_credito")
    private Integer idCredito;
    @JsonProperty("tipo_fiador")
    private String tipoFiador;
}
