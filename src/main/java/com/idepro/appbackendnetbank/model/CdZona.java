package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 28/3/2022.
 */
@Data
public class CdZona {
    @JsonProperty("id_zona")
    private Integer idZona;
    private  String zona;
}
