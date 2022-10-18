package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 6/4/2022.
 */
@Data
public class CdLineaCredito {

    @JsonProperty("id_linea_credito")
    private Integer idLineaCredito;
    @JsonProperty("linea_credito")
    private String lineaCredito;
}
