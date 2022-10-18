package com.idepro.appbackendnetbank.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 23/5/2022.
 */
@Data
public class SudCuotaPagada {
    private Integer numeroTransaccion;
    private String fecha;
    private String descripcion;
    private BigDecimal importe;
}
