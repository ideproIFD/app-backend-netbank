package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Create by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 24/12/2020.
 */
@Data
public class DatosHistoricoPrestamo {

    @JsonProperty("datos_operacion")
    private DatosOperacion datosOperacion;
    private Participante participante;
}
