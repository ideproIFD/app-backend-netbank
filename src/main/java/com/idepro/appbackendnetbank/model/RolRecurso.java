package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 14/5/2021.
 */
@Data
public class RolRecurso {

    @JsonProperty("id_rol")
    private Integer idRol;
    private String rol;
    @JsonProperty("id_recurso")
    private Integer idRecurso;
    private String recurso;
    @JsonProperty("add_user")
    private String addUser;
    private String hora;
    @JsonProperty("add_date")
    private String addDate;

    public RolRecurso() {
    }
}
