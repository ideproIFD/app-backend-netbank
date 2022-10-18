package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 12/5/2021.
 */
@Data
public class Clasificador {
    private Integer prefijo;
    private Integer correlativo;
    private String descripcion;
    private String abreviacion;
    private String tabla;

    public Clasificador() {
    }
}
