package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 3/5/2022.
 */
@Data
public class SoliPago {

    private String ciclo;
    private String codigo;
    private String carnet;
    @JsonProperty("extencion_ci")
    private String extencion;
    @JsonProperty("nombre_completo")
    private String nombre;
    @JsonProperty("telefono_celular")
    private String celular;
    @JsonProperty("es_vendedor")
    private String vendedor;
    private BigDecimal monto;
    private Integer transaccion;
    @JsonProperty("fecha_abono")
    private String fechaAbono;
    private String observacion;

}
