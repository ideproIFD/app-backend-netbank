package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 28/3/2022.
 */
@Data
public class CdAgencia {
    @JsonProperty("id_agencia")
    private Integer idAgencia;
    private String agencia;
    @JsonProperty("id_zona")
    private Integer idZona;
}
