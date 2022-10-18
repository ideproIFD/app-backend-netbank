package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by maruquipa on 19/11/2020.
 */

@Data
public class Codeudor {
    @JsonProperty("id_cliente")
    private Integer idCliente;


}
