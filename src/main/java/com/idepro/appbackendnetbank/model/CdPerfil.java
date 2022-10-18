package com.idepro.appbackendnetbank.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Freddy Lopez Gomez (jhoenlopez@gmail.com) on 15/8/2022.
 */
@Data
@AllArgsConstructor
public class CdPerfil {

    @JsonProperty("id_perfil")
    private String idPerfil;
    private String perfil;
}
