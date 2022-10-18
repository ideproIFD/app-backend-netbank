package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 23/5/2022.
 */
@Data
public class SudPlanPago {
    @JsonProperty("numero_cuota")
    private Integer numeroCuota;
    private String fecha;
}
