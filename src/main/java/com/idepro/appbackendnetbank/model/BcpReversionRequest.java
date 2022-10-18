package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BcpReversionRequest {
    @JsonProperty("canal")
    private Integer canal;
    @JsonProperty("id_pago")
    private Integer idPago;
    @JsonProperty("numero_credito")
    private String numeroCredito;
}
