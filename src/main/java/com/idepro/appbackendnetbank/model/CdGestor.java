package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 28/3/2022.
 */
@Data
public class CdGestor {

    @JsonProperty("id_gestor")
    private Integer idGestor;
    private String nombre;
    @JsonProperty("id_agencia")
    private Integer idAgencia;
    private String usuario;
    @JsonProperty("id_perfil")
    private String idPerfil;
}
