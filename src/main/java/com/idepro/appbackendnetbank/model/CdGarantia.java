package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CdGarantia {
    @JsonProperty("id_garantia")
    private Integer idGarantia;
    private String descripcion;
}
