package com.idepro.appbackendnetbank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BcpPagoResponse {
    private String code;
    private String message;
    private List<WsAxPagoCredito> rows;
}
