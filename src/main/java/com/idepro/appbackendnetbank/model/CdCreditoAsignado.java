package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 6/4/2022.
 */
@Data
public class CdCreditoAsignado {
    @JsonProperty("id_credito_asignado")
    private String idCreditoAsignado;
    @JsonProperty("id_credito")
    private Integer idCredito;
    @JsonProperty("id_gestor")
    private Integer idGestor;
}
