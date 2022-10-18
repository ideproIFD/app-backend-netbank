package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BcpReversionResponse {
    @JsonProperty("numero_credito")
    private String numero_credito;
    @JsonProperty("code")
    private Integer code;
    @JsonProperty("message")
    private String message;
}
