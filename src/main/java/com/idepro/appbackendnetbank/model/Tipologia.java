package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 8/11/2021.
 */
@Data
public class Tipologia {

    @JsonProperty("id_tipologia")
    private Integer idTipologia;
    @JsonProperty("id_subtipologia")
    private Integer idSubTipologia;
    private String descripcion;
    private BigDecimal plazo;

}
