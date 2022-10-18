package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 29/6/2022.
 */
@Data
public class CdGarantiaAsignado {
    @JsonProperty("id_garantia")
    private Integer idGarantia;
    @JsonProperty("id_credito")
    private Integer idCredito;
}
