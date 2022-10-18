package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 21/5/2021.
 */
@Data
public class Reset {
    private String token;
    private String usuario;
    private String fecha;
    @JsonProperty("hora_inicio")
    private String horaInicio;
    @JsonProperty("hora_fin")
    private String horaFin;

    public Reset() {
    }
}
